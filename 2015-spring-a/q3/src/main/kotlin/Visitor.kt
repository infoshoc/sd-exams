interface Visitor<T> {
    fun visit(a: Account): T
    fun visit(p: Profile): T
    fun visit(s: Subscription): T

    fun visit(l: List<T>): T

    fun visit(m: Map<T, T>): T
}