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

class Robot(val position: Position, val dir: Direction, val grid: Grid) {

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
        val newPosition = newDirection.positionTransformer(instruction, position)
        return Robot(grid.accept(newPosition), newDirection, grid)
    }
}