interface RandomGenerator<T> {
    fun get(): T

    companion object {
        fun <T> of(t: T): RandomGenerator<T> {
            return object : RandomGenerator<T> {
                override fun get(): T {
                    return t
                }
            }
        }
    }

    fun <S> flatMap(f: (T) -> RandomGenerator<S>): RandomGenerator<S> {
        return object : RandomGenerator<S> {
            override fun get(): S {
                return f(this@RandomGenerator.get()).get()
            }
        }
    }

    fun <S> map(f: (T) -> S) : RandomGenerator<S> = flatMap { of(f(it)) }
}