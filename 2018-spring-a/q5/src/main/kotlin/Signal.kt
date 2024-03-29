interface Signal<T> {
    fun listen(c: (T)->Unit)

    companion object {
        fun <T> of(s: T): Signal<T> = object : Signal<T> {
            override fun listen(c: (T)->Unit) = c(s)
        }
    }

    fun <C> flatMap(f: (T) -> Signal<C>): Signal<C> {
        return object : Signal<C> {
            override fun listen(c: (C)->Unit) {
                this@Signal.listen { t ->
                    f(t).listen(c)
                }
            }
        }
    }
}
