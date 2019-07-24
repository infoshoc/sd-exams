class ShipCalculatorImpl: ShipCalculator {
    override fun isEntitled(cash: Double, items: Int): Boolean {
        return FreeShippingCalculator.isEntitled(cash, items)
    }
}
