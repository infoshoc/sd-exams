interface Option<T> {
    fun getOrElse(t: T): T
    fun empty(): Boolean
    fun <S> transform(f: (T)->S): Option<S>
}

class Some<T>(
        private val t: T
): Option<T> {
    override fun getOrElse(t: T): T {
        return this.t
    }

    override fun empty(): Boolean { return false }

    override fun <S> transform(f: (T) -> S): Option<S> {
        return OptionFactory<S>().create(f(t))
    }
}

class None<T>: Option<T> {
    override fun getOrElse(t: T): T {
        return t
    }
    override fun empty(): Boolean { return true }

    override fun <S> transform(f: (T) -> S): Option<S> {
        return OptionFactory<S>().create(null)
    }
}

class OptionFactory<T>{
    private val none = None<T>()

    fun create(t: T?): Option<T> {
        return if(null == t) none else Some(t)
    }
}