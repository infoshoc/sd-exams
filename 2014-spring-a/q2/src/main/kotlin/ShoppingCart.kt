import com.google.inject.Inject

class ShoppingCart
@Inject
constructor(private val sc: ShipCalculator = ShipCalculatorImpl()) {
    private var totalCashAdded = 0.0
    private var totalItems = 0

    val isEntitledToFreeShipping: Boolean
        get() = isEntitled(ShipCalculatorImpl())

    fun isEntitled() = isEntitled(sc)

    fun isEntitled(sc: ShipCalculator) = sc.isEntitled(totalCashAdded, totalItems)

    fun addItem(i: Item): ShoppingCart {
        totalCashAdded += i.cost
        totalItems++

        return this
    }
}