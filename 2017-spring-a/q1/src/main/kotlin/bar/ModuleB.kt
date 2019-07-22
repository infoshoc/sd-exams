package bar

import com.authzee.kotlinguice4.KotlinModule
import com.google.inject.Provides
import foo.Foo
import foo.FooChanger
import foo.ModuleA

class ModuleB: KotlinModule() {
    companion object {
        const val newFoo20 = 42;
    }
    /** Configures a [Binder] via the exposed methods.  */
    override fun configure() {
        bind<Int>().toInstance(newFoo20)
    }

    @Provides
    fun overrideFooValue(f: FooChanger): Foo {
        return f.change(newFoo20)
    }
}