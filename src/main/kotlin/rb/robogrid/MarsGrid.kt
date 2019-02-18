package rb.robogrid

interface Grid {
    fun accept(currentPos: Position): Position
}

class MarsGrid(w: Int, h: Int) : Grid {

    // may be over engineered for the initial req. but it's a simple
    // initialisation that sets up for future enhancements (risk of yagni!)

    val zero = Position(0, 0)
    val top = Position(zero.x + w, zero.y + h)

    private val scentedPos = mutableMapOf<Position, Unit>()

    override fun accept(currentPos: Position): Position {
        if(currentPos.x in zero.x .. top.x && currentPos.y in zero.y .. top.y) return currentPos
        if(scentedPos[currentPos] != null) return Position.SCENTED_LOST
        scentedPos[currentPos] = Unit
        return Position.LOST
    }


}