package rb.robogrid

class Grid(w: Int, h: Int) {

    // may be over engineered for the initial req. but it's a simple
    // initialisation that sets up for future enhancements (risk of yagni!)

    val zero = Position(0, 0)
    val top = Position(zero.x + w, zero.y + h)

    fun accept(currentPos: Position): Position {
        if(currentPos.x in zero.x .. top.x && currentPos.y in zero.y .. top.y) return currentPos
        return Position.LOST
    }


}