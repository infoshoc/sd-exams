import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive

import java.util.Arrays
import java.util.HashSet

class Document(private val input: JsonObject) {
    private var status = Status.NEW_BORN

    enum class Status {
        NEW_BORN, READY, NEEDS_MIGRATION, CLOSED
    }

    operator fun get(key: String): String {
        if (this.status != Status.READY)
            throw RuntimeException("Not ready, call warmUp()")
        return input.get("data").asJsonObject.get(key).asString
    }

    fun warmUp(): Status {
        if (status != Status.NEW_BORN)
            throw RuntimeException("must be called exactly once")

        status = if (needMigration()) Status.NEEDS_MIGRATION else Status.READY
        return status
    }

    private fun needMigration(): Boolean {
        return missingFlags().size > 0
    }

    private fun missingFlags(): Set<String> {
        val existing = input.get("flags").asJsonArray
        return HashSet(listOf(*EXPECTED_FLAGS))
                .asSequence()
                .filterNot { f -> existing.contains(JsonPrimitive(f)) }
                .toSet()
    }

    fun migrate() {
        if (status != Status.NEEDS_MIGRATION)
            throw RuntimeException("No migration is needed")
        val first = missingFlags().iterator().next()
        input.get("flags").asJsonArray.add(JsonPrimitive(first))
        status = Status.CLOSED
    }

    companion object {
        val EXPECTED_FLAGS = arrayOf("F1", "F2", "F3")
    }
}