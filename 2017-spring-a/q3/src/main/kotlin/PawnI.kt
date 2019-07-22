class PawnI: PieceI() {
    override fun getMoves(xLocation: Int, yLocation: Int): Collection<Position> {
        return if (yLocation < HEIGHT + 1) listOf(Position(xLocation, yLocation + 1)) else listOf()
    }
}