import java.time.format.DateTimeFormatter

class XMLVisitor: Visitor<String> {

    override fun visit(a: Account): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(p: Profile): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(s: Subscription): String {
        return "<subscription accountId=${s.accountId}, startDate=${s.startDate.format(DateTimeFormatter.ofPattern("dd-MM-yy"))}, endDate=${s.endDate.format(DateTimeFormatter.ofPattern("dd-MM-yy"))}/>"
    }

    override fun visit(l: List<String>): String {
        return "<output>${l.joinToString(""){ it }}</output>"
    }

    override fun visit(m: Map<String, String>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}