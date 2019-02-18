package rb.robogrid

data class Position(val x: Int, val y: Int, val scented: Boolean = false) {

    companion object {
        val LOST = Position(Int.MAX_VALUE, Int.MAX_VALUE)
        val SCENTED_LOST = Position(Int.MAX_VALUE, Int.MAX_VALUE, true)
    }

    init {
        if (x != Int.MAX_VALUE && x !in 0..50) throw IllegalArgumentException("Invalid x: must be in [0, 50]")
        if (y != Int.MAX_VALUE && y !in 0..50) throw IllegalArgumentException("Invalid y: must be in [0, 50]")
    }

    fun inc_y(): Position = Position(x, y + 1)
    fun inc_x(): Position = Position(x + 1, y)
    fun dec_y(): Position = Position(x, y - 1)
    fun dec_x(): Position = Position(x - 1, y)

    override fun toString(): String {
        if (this == LOST) return "LOST"
        return "$x $y"
    }

}