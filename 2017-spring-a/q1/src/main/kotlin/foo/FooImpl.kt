package foo

internal open class FooImpl: Foo {
    override fun foo1(): Int {
        return 1
    }

    override fun foo2(): Int {
        return 2
    }

    override fun foo20(): Int {
        return 20
    }
}