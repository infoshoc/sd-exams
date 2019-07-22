class RookI: PieceI() {
    override fun getMoves(xLocation: Int, yLocation: Int): Collection<Position> {
        return ((0 until WIDTH).filter { it != xLocation }.map { Position(it, yLocation) }
                + (0 until HEIGHT).filter { it != yLocation }.map{Position(xLocation, it)})
    }
}