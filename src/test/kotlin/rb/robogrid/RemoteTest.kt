package rb.robogrid

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class RemoteTest {
    private val currentGrid = MarsGrid(5, 3)
    private val robot = Robot(Position(1,1), Direction.E, currentGrid)

    @Test
    fun `processes all instructions on the given robot`() {
        val acc = mutableListOf<Robot>()
        Remote.execute(robot, listOf(
                Instruction.R,
                Instruction.F,
                Instruction.R,
                Instruction.F,
                Instruction.R,
                Instruction.F,
                Instruction.R,
                Instruction.F
                )) {
            acc.add(it)
        }

        assertThat(acc.last().toString(), `is`("1 1 E"))
    }
}