import com.authzee.kotlinguice4.KotlinModule

class ShoppingModule: KotlinModule() {
    override fun configure() {
        bind<ShipCalculator>().to<ShipCalculatorImpl>()
    }
}