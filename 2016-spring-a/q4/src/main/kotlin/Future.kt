class Future<T>(s: () -> T) {
    private val thread: Thread
    private var value: T? = null

    init {
        this.thread = Thread { this.value = s.invoke() }
        this.thread.start()
    }

    fun get(): T {
        thread.join()
        return value!!
    }

    // Monadic functions:

    fun <S> flatMap(f: (T) -> Future<S>): Future<S> = Future { f.invoke(this.get()).get() }

    companion object {
        fun <T> of(t: T): Future<T> {
            // if we want, we can optimize this to be threadless
            return Future { t }
        }
    }


    fun <S> map(f: (T) -> S) = flatMap { of(f(it)) }
}


