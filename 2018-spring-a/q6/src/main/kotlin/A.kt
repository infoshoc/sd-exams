import com.google.inject.Inject

class A
@Inject
constructor() {
    public fun getB(): B {
        return _b
    }

    public lateinit var _b: B

    @Inject
    public fun setB(b: B) {
        _b = b
    }
}