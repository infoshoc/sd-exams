import org.junit.jupiter.api.Assertions.assertEquals
import java.util.ArrayList
import org.junit.jupiter.api.Test


class SignalTest {
    @Test
    fun testOf() {
        val ss = Signal.of("foo")
        val ls = mutableListOf<String>()
        ss.listen({x -> ls.add(x)})
        ss.listen({x -> ls.add(x)})
        assertEquals(listOf("foo", "foo"), ls)
    }

    @Test
    fun testFlatMap() {
        val ss = Signal.of("foobar")
        val si = ss.flatMap({ s -> Signal.of(s.length) })
        val li = ArrayList<Int>()
        si.listen({x -> li.add(x)})
        assertEquals(listOf(6), li)
    }
}