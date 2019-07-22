import com.authzee.kotlinguice4.getInstance
import com.google.inject.Guice
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ABTest {
    @Test
    public fun test() {
        val i = Guice.createInjector(TestModule())
        val a = i.getInstance<A>()
        val b = i.getInstance<B>()

        Assertions.assertSame(a.getB(), b)
        Assertions.assertSame(b.getA(), a)
    }
}