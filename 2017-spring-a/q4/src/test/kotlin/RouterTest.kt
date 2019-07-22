import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RouterTest {
    @Test
    fun `test 1000 random calls`() {
        val cg = combine(
                IntGenerator(),
                combine(StringGenerator(), StringGenerator())
                        .map { (caller, callee) -> Parties(caller, callee)  },
                StringGenerator()).map { (i, p, n) -> Call(i, p, n) }

        val calls = (0 until 1000).map {
            cg.get()
        }.toList()

        assertTrue(Router().routeCalls(calls))
    }
}