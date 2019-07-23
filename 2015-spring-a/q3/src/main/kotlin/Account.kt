class Account(
        public val accountName: String,
        public val accountId: Int
): Profile() {
    override fun <T> accept(v: Visitor<T>): T {
        return v.visit(this)
    }
}