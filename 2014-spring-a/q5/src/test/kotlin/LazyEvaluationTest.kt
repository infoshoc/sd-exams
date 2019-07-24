import io.mockk.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javafx.beans.binding.Bindings.`when`



class LazyEvaluationTest {
    @Test
    fun testEval() {
        val mock = mockk<StringFunction>()
        every { mock.apply() }  returns "test"
        val le = LazyEvaluation(mock)
        verify {mock wasNot Called }
        assertEquals("test", le.eval())
        assertEquals("test", le.eval())
        verify { mock.apply() }
        confirmVerified()
    }

    @Test
    fun testMap() {
        val mock1 = mockk<StringFunction>()
        every { mock1.apply() } returns "1"
        val mock2 = mockk<StringToIntFunction>()
        every { mock2.apply("1") } returns 1
        val le = LazyEvaluation(mock1).map(mock2)
        verify {
            mock1 wasNot called
            mock2 wasNot called
        }

        assertEquals(1, le.eval())
        assertEquals(1, le.eval())

        verifyAll {
            mock1.apply()
            mock2.apply("1")
        }

        confirmVerified()

    }
}
