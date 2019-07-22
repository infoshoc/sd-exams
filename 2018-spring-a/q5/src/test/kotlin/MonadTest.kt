import org.junit.jupiter.api.Test

class MonadTest {
    @Test
    fun `left identity`() {
        val s = "football"
        val f: (String) -> Signal<Int> = { Signal.of(it.length) }

        sameSignal(Signal.of(s).flatMap(f), f(s))
    }

    @Test
    fun `right identity`() {
        val m = Signal.of("football")

        sameSignal(m.flatMap{Signal.of(it)}, m)
    }

    @Test
    fun associativity() {
        val f: (String) -> Signal<Int> = {Signal.of(it.length)}
        val g: (Int) -> Signal<Int> = {Signal.of(it + 1)}
        val m = Signal.of("football")

        sameSignal(m.flatMap(f).flatMap(g), m.flatMap{f(it).flatMap(g)})
    }

    companion object {
        fun <T> sameSignal(a: Signal<T>, b: Signal<T>) {
            val aa = mutableListOf<T>()
            val bb = mutableListOf<T>()

            a.listen{aaa -> aa.add(aaa)}
            b.listen{aaa -> bb.add(aaa)}
        }
    }
}