class LibClass(private val f: IntFunction) {
    fun run(n: Int) {
        println("Got this value: " + f.apply(n))
    }
}