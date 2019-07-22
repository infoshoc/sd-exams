abstract class PieceII {
    protected abstract fun getMoves(xLocation: Int, yLocation: Int): (Position) -> Boolean
    fun canMove(xSource: Int, ySource: Int, xDst: Int, yDst: Int): Boolean {
        return getMoves(xSource, ySource)(Position(xDst, yDst))
    }

    companion object {
        var WIDTH = Int.MAX_VALUE
        var HEIGHT = Int.MAX_VALUE
    }
}

