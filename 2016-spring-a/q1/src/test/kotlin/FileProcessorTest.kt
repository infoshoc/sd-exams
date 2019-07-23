import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class FileProcessorTest {
    @Test
    fun test() {
        val r = mockk<Reader>()
        val w = mockk<Writer>(relaxed = true)

        every { r.hasNextLine() } returnsMany listOf(true, true, false)
        every { r.nextLine() } returnsMany listOf("Aa", "bB")

        FileProcessor().processFile(r, w)

        verify {
            w.appendLine("aa")
            w.appendLine("bb")
        }
        confirmVerified()
    }
}