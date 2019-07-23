import com.authzee.kotlinguice4.KotlinModule
import com.google.inject.Provides
import com.google.inject.Singleton

class SecondModule: KotlinModule() {
    override fun configure() {
        bind<IntFunction>().to<Previous>().`in`<Singleton>()
    }

    @Provides
    fun provideLibClass(f: IntFunction): LibClass {
        return LibClass(f)
    }
}