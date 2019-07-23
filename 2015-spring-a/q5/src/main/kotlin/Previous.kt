class Previous : IntFunction {
    internal var prev = 0
    override fun apply(a: Int): Int {
        val `$` = prev
        prev = a
        return `$`
    }
}