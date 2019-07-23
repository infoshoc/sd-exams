import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class MessageTest {
    @Test
    fun test() {
        val mp= mockk<MessagePersister>(relaxed = true)
        val message = Message()

        message.save(mp)

        verify { mp.save(message) }
        confirmVerified()

        message.load(mp)

        every { mp.load() } returns message

        verify { mp.load() }
        confirmVerified()
    }
}