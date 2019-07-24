class LazyEvaluation<T>(
        private val f: Function<T>
){
    private var ready = false
    private var t: T? = null
    private var exceptional: Boolean = false
    private var e: Throwable? = null

    fun eval(): T {
        if (!ready) {
            try {
                t = f.apply()
            } catch (e: Throwable) {
                exceptional = true
                this.e = e
            }

            ready = true
        }

        if (exceptional) {
            throw e!!
        }

        return t!!
    }

    fun <S> map(ff: Function2<T, S>): LazyEvaluation<S> = LazyEvaluation(object : Function<S>{
        override fun apply(): S {
            return ff.apply(eval())
        }
    })
}