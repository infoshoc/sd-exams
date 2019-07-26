interface Reader<in A, out B> {
    fun read(a: A): B

    companion object {
        fun <A, B> of(b: B) = object : Reader<A, B> {
            override fun read(a: A): B = b
        }
    }

    fun <C> flatMap(f: (B) -> Reader<@UnsafeVariance A, C>): Reader<A, C> = object : Reader<A, C> {
        override fun read(a: A): C = f(this@Reader.read(a)).read(a)
    }
}