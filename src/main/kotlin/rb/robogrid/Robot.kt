package rb.robogrid

import java.lang.IllegalArgumentException

enum class Direction {
    N, S, E, W
}

enum class Instruction {
    L, R, F
}

class Robot(val x: Int, val y: Int, val dir: Direction) {

    private val directionsMap = mapOf(
            Pair(Direction.E, Instruction.L) to Direction.N
    )

    init {
        if (x < 0 || x > 50) throw IllegalArgumentException("Invalid x: must be in [0, 50]")
        if (y < 0 || y > 50) throw IllegalArgumentException("Invalid y: must be in [0, 50]")
    }

    override fun toString() = "$x $y ${dir.name}"

    fun apply(instruction: Instruction): Robot {
        val newDirection = directionsMap[Pair(dir, instruction)] ?: dir
        return Robot(x, y, newDirection)
    }
}