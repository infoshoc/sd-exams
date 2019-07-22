import kotlin.math.abs

class ManhattanDistance(private val d: Int): PieceII() {
    override fun getMoves(xLocation: Int, yLocation: Int): (Position) -> Boolean = {
        abs(xLocation - it.x) + abs(yLocation - it.y) <= d
    }
}