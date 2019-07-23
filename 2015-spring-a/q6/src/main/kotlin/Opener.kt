import com.google.gson.JsonObject

class Opener(
        private val jo: JsonObject,
        private var n: Long
) {
    private var d: Document? = null;
    private var status: Document.Status? = null

    fun tryToOpen(): Document.Status {
        d = Document(jo)

        if (n <= 0) {
            throw RuntimeException("Number of tries exceeded")
        }

        --n;
        status = d!!.warmUp()

        return status!!
    }

    fun get(): Document {
        if (status != Document.Status.READY) {
            throw RuntimeException("Document is not ready")
        }

        return d!!
    }

    fun migrate() {
        if (status != Document.Status.NEEDS_MIGRATION) {
            throw RuntimeException("Document does not need migration")
        }
        d!!.migrate()
    }
}