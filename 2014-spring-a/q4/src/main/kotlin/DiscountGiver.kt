class DiscountGiver: Visitor<Int> {
    override fun visit(a: Account): Int {
        return ACCOUNT_DISCOUNT
    }

    override fun visit(a: GoldAccount): Int {
        return GOLD_DISCOUNT
    }

    override fun visit(a: SuperGoldAccount): Int {
        return SUPER_DISCOUNT
    }

    fun getDiscount(a: Account): Int {
        return a.accept(this)
    }

    companion object {
        val ACCOUNT_DISCOUNT = 10
        val GOLD_DISCOUNT = 20
        val SUPER_DISCOUNT = 50
    }
}