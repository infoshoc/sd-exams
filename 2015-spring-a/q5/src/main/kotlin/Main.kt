import com.google.inject.Guice
import com.google.inject.Injector

fun main(args: Array<String>) {
    val inj = Guice.createInjector(SecondModule())
    inj.getInstance(IntFunction::class.java).apply(500)
    foo(inj, 600)
    foo(inj, 700)
    foo(inj, 800)
}

private fun foo(inj: Injector, n: Int) {
    val lc = inj.getInstance(LibClass::class.java)
    lc.run(n)
    assert(lc != inj.getInstance(LibClass::class.java)) // not a singleton
}
