import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.assertion.assertThat
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.IOException

class LineProcessorTest {
    @Test
    fun `reads and converts one line to lower`() {
        val bf = mockk<BufferedReader>()
        val lines: MutableList<String> = mutableListOf<String>()

        every { bf.readLine() } returns "Ab"

        assertThat(LinesProcessor1(bf, lines).process(), equalTo(true))

        verify {bf.readLine()}
        confirmVerified()
        assertEquals(lines, listOf("ab"))
    }
}