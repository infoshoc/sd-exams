import java.util.function.Supplier
import kotlin.reflect.KFunction

class Database<T : AbstractTableLocator>(
        private val name: String,
        private val port: Int,
        private val supplier: KFunction<T>
) {
    companion object {
        val mySql: Database<MySqlTableLocator> = Database("mysql", 9003, ::MySqlTableLocator)
        val postgreSql: Database<PostgreSqlTableLocator> = Database("postgresql", 20803, ::PostgreSqlTableLocator)
    }

    fun create(): T {
        val result = supplier.call();

        result.configure(name, port);

        return result;
    }
}

class PostgreSqlTableLocator: AbstractTableLocator()

class MySqlTableLocator: AbstractTableLocator()

open class AbstractTableLocator {
    private lateinit var name: String
    private var port: Int? = null
    private lateinit var map: Map<String, String?>

    fun configure(name: String, port: Int) {
        this.name = name;
        this.port = port;
    }

    fun getName(): String { return name; }

    fun getPort(): Int { return port!!; }

    fun setTables(userLookupTble: String?, activityTable: String?, loggingTable: String?) {
        val map: MutableMap<String, String?> = HashMap()

        map.put("user", userLookupTble);
        map.put("activity", activityTable);
        map.put("logging", loggingTable);

        this.map = map;
    }

    fun getTableMapping(): Map<String, String?> {
        return map
    }
}


class TableLocator : AbstractTableLocator() {

    companion object {
        class Builder <T : AbstractTableLocator>
        {
            var logt: String? = null
            var lookt: String? = null
            var actt: String? = null
            lateinit var d: Database<T>

            fun withLoggingTable(logt: String): Builder<T> {
                this.logt = logt
                return this
            }
            fun withUserLookupTable(lookt: String): Builder<T> {
                this.lookt = lookt
                return this
            }
            fun <S: AbstractTableLocator> withDatabase(d: Database<S>): Builder<S> {
                val b = Builder<S>()
                b.logt = logt
                b.lookt = lookt
                b.actt = actt
                b.d  = d

                return b
            }
            fun withActivityTable(actt: String): Builder<T> {
                this.actt = actt
                return this
            }

            fun build(): T {
                val tl = d.create()

                tl.setTables(lookt, actt, logt)

                return tl
            }
        }

        fun newBuilder(): Builder<AbstractTableLocator> {
            return Builder()
        }
    }
}