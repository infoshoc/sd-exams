import com.google.inject.Inject

class B
@Inject
constructor(private val a: A) {
    public fun getA(): A {
        return a
    }
}