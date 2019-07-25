import java.io.PrintWriter

interface Room
interface Pool {
    fun size(): Int
}

interface Stable {
    fun horseCount(): String
}

open class House(val rooms: List<Room>) {
    fun houseDescription(pw: PrintWriter) {
        pw.println("Num rooms =" + rooms.size)
        for (r in rooms)
            pw.println(r)
        innerHouseDescription(pw)
    }

    protected open fun innerHouseDescription(pw: PrintWriter) {}
}

class Villa(rooms: List<Room>, val pool: Pool) : House(rooms) {
    override fun innerHouseDescription(pw: PrintWriter) {
        pw.println("Pool size =" + pool.size())
    }
}

class Farm(rooms: List<Room>, val stable: Stable) : House(rooms) {
    override fun innerHouseDescription(pw: PrintWriter) {
        pw.println("Number of horses =" + stable.horseCount())
    }
}