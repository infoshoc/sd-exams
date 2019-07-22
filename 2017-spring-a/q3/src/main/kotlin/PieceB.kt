abstract class PieceB
(private val pieces: List<PieceII>)
    : PieceII()
 {
     override fun getMoves(xLocation: Int, yLocation: Int): (Position) -> Boolean = { p ->
         pieces.any{ it.canMove(xLocation, yLocation, p.x, p.y)}
     }
}