package rb.robogrid

enum class Direction(val positionTransformer: (Int, Int) -> Pair<Int, Int>) {
    N({ x, y -> Pair(x, y + 1) }),
    S({ x, y -> Pair(x, y - 1) }),
    E({ x, y -> Pair(x + 1, y) }),
    W({ x, y -> Pair(x - 1, y) })
}

enum class Instruction {
    L, R, F
}

class Robot(val x: Int, val y: Int, val dir: Direction) {

    private val directionsMap = mapOf(
            Pair(Direction.E, Instruction.L) to Direction.N,
            Pair(Direction.N, Instruction.L) to Direction.W,
            Pair(Direction.W, Instruction.L) to Direction.S,
            Pair(Direction.S, Instruction.L) to Direction.E,

            Pair(Direction.E, Instruction.R) to Direction.S,
            Pair(Direction.N, Instruction.R) to Direction.E,
            Pair(Direction.W, Instruction.R) to Direction.N,
            Pair(Direction.S, Instruction.R) to Direction.W
    )

    init {
        if (x < 0 || x > 50) throw IllegalArgumentException("Invalid x: must be in [0, 50]")
        if (y < 0 || y > 50) throw IllegalArgumentException("Invalid y: must be in [0, 50]")
    }

    override fun toString() = "$x $y ${dir.name}"

    fun apply(instruction: Instruction): Robot {
        val newDirection = directionsMap[Pair(dir, instruction)] ?: dir

        val newPosition = newDirection.positionTransformer(x, y)

        return Robot(newPosition.first, newPosition.second, newDirection)
    }
}