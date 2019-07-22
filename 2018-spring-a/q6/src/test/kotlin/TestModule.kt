import com.authzee.kotlinguice4.KotlinModule

class TestModule: KotlinModule() {
    override fun configure() {
        val a = A()
        val b = B(a)

        a.setB(b)

        bind<A>().toInstance(a)
        bind<B>().toInstance(b)
    }
}
