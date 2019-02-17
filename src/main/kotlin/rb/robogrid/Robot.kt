package rb.robogrid

import java.lang.IllegalArgumentException

enum class Direction {
    N, S, E, W
}

class Robot(val x: Int, val y: Int, val dir: Direction) {

    init {
        if (x < 0 || x > 50) throw IllegalArgumentException("Invalid x: must be in [0, 50]")
    }

    override fun toString() = "$x $y ${dir.name}"
}