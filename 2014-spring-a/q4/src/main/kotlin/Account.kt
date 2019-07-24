open class Account {
    open fun <T> accept(v: Visitor<T>): T {
        return v.visit(this)
    }
}
