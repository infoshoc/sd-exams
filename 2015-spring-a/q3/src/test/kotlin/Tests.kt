import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Tests {
    companion object {
        fun parseDate(s: String): LocalDate {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("dd-MM-yy"))
        }
    }

    @Test
    fun example1() {
        val profiles = mutableListOf<Profile>();
        profiles.add(Account("a1", 10));
        profiles.add(Account("a2", 20));
        assertEquals("[{accountName: 'a1', accountId: 10}, {accountName: 'a2', accountId: 20}]",
                getFormatString("JSON", profiles));
    }

    @Test
    fun example2() {
        val subscriptions = mutableListOf<Subscription>()
        subscriptions.add(Subscription(10, parseDate("10-01-15"), parseDate("10-01-16")))
        subscriptions.add(Subscription("a2", parseDate("18-03-14"), parseDate("18-03-15")))
        assertEquals("<output><subscription accountId=10, startDate=10-01-15, endDate=10-01-16/><subscription accountId=20, startDate=18-03-14, endDate=18-03-15/></output>",
                getFormatString("XML", subscriptions));
    }
}