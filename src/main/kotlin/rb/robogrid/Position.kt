package rb.robogrid

data class Position (val x: Int, val y: Int) {

    init {
        if (x < 0 || x > 50) throw IllegalArgumentException("Invalid x: must be in [0, 50]")
        if (y < 0 || y > 50) throw IllegalArgumentException("Invalid y: must be in [0, 50]")
    }


    fun inc_y(): Position = Position(x, y + 1)
    fun inc_x(): Position = Position(x + 1, y)
    fun dec_y(): Position = Position(x, y - 1)
    fun dec_x(): Position = Position(x - 1, y)
}