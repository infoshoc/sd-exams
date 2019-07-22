
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FreshValueTest {
    @Test
    fun testIsFresh() {
        val `$`: FreshValue<Int> = FreshValue()
        `$`.set(0)
        assertTrue(`$`.isFresh)
        Thread.sleep(1000)
        assertFalse(`$`.isFresh)
    }

    @Test
    fun `test is fresh`() {
        val clock = object {
            private var currentTimeMillis = 0L

            fun getCurrentTimeMillis(): Long {
                return currentTimeMillis
            }
            fun setCurrentTimeMillis(ctm: Long) {
                this.currentTimeMillis = ctm
            }
        }

        val v = FreshValue<Int>(clock::getCurrentTimeMillis)
        v.set(0)
        clock.setCurrentTimeMillis(999)
        assertTrue(v.isFresh)
        clock.setCurrentTimeMillis(1000)
        assertFalse(v.isFresh)
    }
}