package foo

import com.authzee.kotlinguice4.KotlinModule

class ModuleA: KotlinModule() {
    /** Configures a [Binder] via the exposed methods.  */
    override fun configure() {
        bind<Foo>().to<FooImpl>()
        bind<FooChanger>().toInstance(object: FooChanger {
            override fun change(newValue20: Int): Foo {
                return object : FooImpl() {
                    override fun foo20(): Int {
                        return newValue20
                    }
                }
            }
        })
    }
}