import com.google.gson.JsonParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

class DocumentTest {
    @Test
    fun returnsAValueFromTheDataMap() {
        val doc = Document(
                JsonParser()
                        .parse("{flags: ['F1', 'F2', 'F3'], data: {a: 'A'}}")
                        .asJsonObject
        )
        doc.warmUp()
        assertEquals("A", doc["a"])
    }

    @Test
    fun `needs migration if flag is missing`(){
        val jsonObject = JsonParser()
                .parse("{flags: ['F1', 'F2'], data: {a: 'A'}}")
                .asJsonObject
        var doc = Document(
                jsonObject
        )

        assertEquals(Document.Status.NEEDS_MIGRATION, doc.warmUp())
        doc.migrate()
        doc = Document(jsonObject)
        assertEquals(Document.Status.READY, doc.warmUp())
        assertEquals("A", doc["a"])
    }

    @Test
    fun `fail if warm up is not called`() {
        val doc = Document(
                JsonParser()
                        .parse("{flags: ['F1', 'F2', 'F3'], data: {a: 'A'}}")
                        .asJsonObject
        )
        assertThrows<RuntimeException> { doc.get("a") }
    }
}

