internal class Rook : Piece() {
    override fun getMoves(xLocation: Int, yLocation: Int): Array<BooleanArray> {
        val result = Array(Piece.WIDTH) { BooleanArray(Piece.HEIGHT) }
        for (x in 0 until Piece.WIDTH)
            result[x][yLocation] = x != xLocation
        for (y in 0 until Piece.HEIGHT)
            result[xLocation][y] = y != yLocation
        return result
    }
}