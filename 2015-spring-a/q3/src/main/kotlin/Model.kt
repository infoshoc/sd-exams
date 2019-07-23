interface Model {
    fun <T> accept(v: Visitor<T>): T
}