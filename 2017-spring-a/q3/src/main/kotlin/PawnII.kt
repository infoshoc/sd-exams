class PawnII: PieceII() {
    override fun getMoves(xLocation: Int, yLocation: Int): (Position) -> Boolean {
        return {
            yLocation < HEIGHT - 1 && it.y == yLocation + 1
        }
    }
}