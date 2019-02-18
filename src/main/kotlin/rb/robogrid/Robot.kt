package rb.robogrid

enum class Direction(val positionTransformer: (Position) -> Position) {
    N({ p -> p.inc_y() }),
    S({ p -> p.dec_y() }),
    E({ p -> p.inc_x()}),
    W({ p -> p.dec_x() })
}

enum class Instruction {
    L, R, F
}

class Robot(val position: Position, val dir: Direction) {

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

    override fun toString() = "$position ${dir.name}"

    fun apply(instruction: Instruction): Robot {
        val newDirection = directionsMap[Pair(dir, instruction)] ?: dir
        val newPosition = newDirection.positionTransformer(position)
        return Robot(newPosition, newDirection)
    }
}