import com.google.inject.Guice
import io.mockk.*
import org.junit.jupiter.api.Test

class AuthControllerTest {
    val tokenMock = mockk<AuthToken>()
    val tokenFactory = mockk<TokenFactory>()

    init {
        every { tokenFactory.get() } returns tokenMock
        every { tokenFactory.getNewToken() } returns tokenMock
    }

    @Test
    fun test1() {
        every { tokenMock.hasExpired() } returns false

        val ac = AuthController(tokenFactory)

        ac.process("")

        verifyAll {
            tokenFactory.get()
            tokenFactory.getNewToken() wasNot called
        }
        confirmVerified(tokenFactory)
    }

    @Test
    fun test2() {
        every { tokenMock.hasExpired() } returns true

        val ac = AuthController(tokenFactory)

        ac.process("")

        verifyAll {
            tokenFactory.get()
            tokenFactory.getNewToken()
        }
        confirmVerified(tokenFactory)
    }
}