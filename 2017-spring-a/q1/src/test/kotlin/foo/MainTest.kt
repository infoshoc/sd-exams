package foo

import bar.ModuleB
import com.authzee.kotlinguice4.getInstance
import com.google.inject.util.Modules
import com.google.inject.Guice
import com.google.inject.Injector
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



class MainTest {
    @Test
    fun test() {
        val injector = Guice.createInjector(Modules.override(ModuleA()).with(ModuleB()))
        val foo = injector.getInstance<Foo>()
        assertEquals(foo.foo20(), ModuleB.newFoo20)
    }
}