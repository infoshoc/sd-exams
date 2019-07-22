class RookII: PieceII() {
    override fun getMoves(xLocation: Int, yLocation: Int): (Position) -> Boolean {
        return {
            (0 <= it.x && it.x < WIDTH && it.x != xLocation && it.y == yLocation
                    || 0 <= it.y && it.y < HEIGHT && it.y != yLocation && it.x == xLocation)
        }
    }
}