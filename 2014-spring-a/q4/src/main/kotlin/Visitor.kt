interface Visitor<T> {
    fun visit(a: Account): T
    fun visit(a: GoldAccount): T
    fun visit(a: SuperGoldAccount): T
}