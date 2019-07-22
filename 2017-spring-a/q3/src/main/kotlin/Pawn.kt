internal class Pawn : Piece() {
    override fun getMoves(xLocation: Int, yLocation: Int): Array<BooleanArray> {
        val result = Array(Piece.WIDTH) { BooleanArray(Piece.HEIGHT) }
        if (yLocation < Piece.HEIGHT - 1)
            result[xLocation][yLocation + 1] = true
        return result
    }
}