import java.time.LocalDate
import java.util.*

class Subscription(
        public val accountId: Int,
        public val startDate: LocalDate,
        public val endDate: LocalDate
): Model {
    override fun <T> accept(v: Visitor<T>): T {
        return v.visit(this)
    }

    constructor(
            accountName: String,
            startDate: LocalDate,
            endDate: LocalDate
    ) : this(20, startDate, endDate)
}