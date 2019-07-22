internal abstract class Piece {
    protected abstract fun getMoves(xLocation: Int, yLocation: Int): Array<BooleanArray>
    fun canMove(xSource: Int, ySource: Int, xDst: Int, yDst: Int): Boolean {
        return getMoves(xSource, ySource)[xDst][yDst]
    }

    companion object {
        var WIDTH = 100
        var HEIGHT = 100
    }
}