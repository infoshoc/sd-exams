abstract class PieceI {
    protected abstract fun getMoves(xLocation: Int, yLocation: Int): Collection<Position>
    fun canMove(xSource: Int, ySource: Int, xDst: Int, yDst: Int): Boolean {
        return getMoves(xSource, ySource).contains(Position(xDst, yDst))
    }

    companion object {
        var WIDTH = 100
        var HEIGHT = 100
    }
}

