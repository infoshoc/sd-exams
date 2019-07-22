
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test


class TableLocatorTest {
    @Test
    fun buildsMySqlTableLocator() {
        val o1 = TableLocator.newBuilder()
                .withLoggingTable("l_1")
                .withUserLookupTable("u_1")
                .withDatabase(Database.mySql)
                .build()
        assertEquals("mysql", o1.getName())
        assertEquals(9003, o1.getPort())
        assertEquals("u_1", o1.getTableMapping().get("user"))
        assertNull(o1.getTableMapping().get("activity"))
        assertEquals("l_1", o1.getTableMapping().get("logging"))
    }

    @Test
    fun buildsPostgreSqlTableLocator() {
        val o2 = TableLocator.newBuilder()
                .withLoggingTable("l_2")
                .withDatabase(Database.postgreSql)
                .withActivityTable("a_2")
                .build()
        assertEquals("postgresql", o2.getName())
        assertEquals(20803, o2.getPort())
        assertNull(o2.getTableMapping().get("user"))
        assertEquals("a_2", o2.getTableMapping().get("activity"))
        assertEquals("l_2", o2.getTableMapping().get("logging"))
    }
}