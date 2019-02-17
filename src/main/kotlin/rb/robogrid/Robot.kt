package rb.robogrid

enum class Direction {
    N, S, E, W
}

class Robot(val x: Int, val y: Int, val dir: Direction) {

    override fun toString() = "$x $y ${dir.name}"
}