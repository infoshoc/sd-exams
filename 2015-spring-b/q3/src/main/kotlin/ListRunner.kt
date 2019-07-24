interface Model {
    fun accept(v: Visitor)
}
class Profile : Model {
    override fun accept(v: Visitor) { v.visit(this) }
}
class Account : Model {
    override fun accept(v: Visitor) { v.visit(this) }
}
class Subscription : Model {
    override fun accept(v: Visitor) { v.visit(this) }
}

interface Visitor {
    fun visit(p: Profile)
    fun visit(a: Account)
    fun visit(s: Subscription)
}

interface ListRunner: Visitor {
    fun run(p: Profile)
    fun run(a: Account)
    fun run(s: Subscription)

    fun runOnAll(ps: List<Model>) {
        ps.forEach{it.accept(this)}
    }

    override fun visit(p: Profile) {
        run(p)
    }
    override fun visit(a: Account) {
        run(a)
    }
    override fun visit(s: Subscription) {
        run(s)
    }
}