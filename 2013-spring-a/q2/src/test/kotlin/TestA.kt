import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.IOException
import java.io.StringReader

abstract class TestA(private val a: A) {
    private var readers: MutableList<BufferedReader>? = null
    @BeforeEach
    fun prepareReaders() {
        readers = mutableListOf()
        readers!!.add(BufferedReader(StringReader("A")))
        readers!!.add(BufferedReader(StringReader("B\nC")))
    }

    @AfterEach
    @Throws(IOException::class)
    fun closeReaders() {
        for (br in readers!!) {
            br.close()
        }
    }

    @Test
    @Throws(IOException::class)
    fun testA() {
        val lines = mutableListOf<String>()
        assertEquals(3, a.processAll(readers!!, lines))
        assertTrue(lines.contains("a"))
        assertTrue(lines.contains("b"))
        assertTrue(lines.contains("c"))
    }
}