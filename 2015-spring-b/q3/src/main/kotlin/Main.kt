fun main() {
    val p1 = Profile()
    val p2 = Profile()
    val a1 = Account()
    val a2 = Account()
    val s1 = Subscription()
    val s2 = Subscription()
    val lr = ListRunnerImpl()

    lr.runOnAll(listOf(p1, p2))
    lr.runOnAll(listOf(a1, a2))
    lr.runOnAll(listOf(s1, s2))
}