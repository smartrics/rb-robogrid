package rb.robogrid

enum class Direction(val positionTransformer: (Instruction, Position) -> Position) {
    N({ i, p -> if (i == Instruction.F) p.inc_y() else p }),
    S({ i, p -> if (i == Instruction.F) p.dec_y() else p }),
    E({ i, p -> if (i == Instruction.F) p.inc_x() else p }),
    W({ i, p -> if (i == Instruction.F) p.dec_x() else p })
}

enum class Instruction {
    L, R, F
}

class Robot(val position: Position, val dir: Direction, val grid: Grid, val lost: Boolean = false) {

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

    override fun toString() = "$position ${dir.name}${if (lost) " LOST" else ""}"

    fun apply(instruction: Instruction): Robot {
        if(lost) return this
        val newDirection = directionsMap[Pair(dir, instruction)] ?: dir
        val newPosition = grid.accept(newDirection.positionTransformer(instruction, position))
        if(newPosition.lost)
            return Robot(position, newDirection, grid, true)
        else
            return Robot(newPosition, newDirection, grid)
    }
}