internal class FreshValue<T>
(private val getCurrentTimeMillis: ()->Long = System :: currentTimeMillis) {
    private var lastUpdateTime: Long = 0
    private var t: T? = null

    val isFresh: Boolean
        get() = getCurrentTimeMillis() - lastUpdateTime < 1000

    fun set(t: T) {
        this.t = t
        lastUpdateTime = getCurrentTimeMillis()
    }

}