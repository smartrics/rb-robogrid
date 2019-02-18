package rb.robogrid

data class Position (val x: Int, val y: Int) {
    fun inc_y(): Position = Position(x, y + 1)
    fun inc_x(): Position = Position(x + 1, y)
    fun dec_y(): Position = Position(x, y - 1)
    fun dec_x(): Position = Position(x - 1, y)
}