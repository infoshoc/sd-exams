open class Profile: Model {
    override fun <T> accept(v: Visitor<T>): T {
        return v.visit(this)
    }
}