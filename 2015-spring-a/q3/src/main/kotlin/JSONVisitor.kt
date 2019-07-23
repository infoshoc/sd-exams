class JSONVisitor: Visitor<String> {

    override fun visit(a: Account): String {
        return "{accountName: '${a.accountName}', accountId: ${a.accountId}}"
    }

    override fun visit(p: Profile): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(s: Subscription): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(l: List<String>): String {
        return "[${l.joinToString(", "){it}}]"
    }

    override fun visit(m: Map<String, String>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}