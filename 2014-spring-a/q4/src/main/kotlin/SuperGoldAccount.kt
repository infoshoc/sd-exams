class SuperGoldAccount: GoldAccount() {
    override fun <T> accept(v: Visitor<T>): T {
        return v.visit(this)
    }
}
