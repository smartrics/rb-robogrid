package rb.robogrid

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.lang.IllegalArgumentException

class RobotTest {

    @Test
    fun `robot string representation matches its current position and direction separate by one space`() {
        // test passes if the code compiles
        assertThat(Robot(1, 1, Direction.E).toString(), `is`("1 1 E"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `robot x coordinate cannot be bigger than 50`() {
        Robot(x = 51, y = 0, dir = Direction.E)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `robot x coordinate cannot be smaller than 0`() {
        Robot(x = -1, y = 0, dir = Direction.E)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `robot y coordinate cannot be bigger than 50`() {
        Robot(x = 0, y = 51, dir = Direction.E)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `robot y coordinate cannot be smaller than 0`() {
        Robot(x = 0, y = -1, dir = Direction.E)
    }

    @Test
    fun `robot instructed to move left changes direction`() {
        assertThat(newRobotWith(Direction.E).apply(Instruction.L).dir, `is`(Direction.N))
        assertThat(newRobotWith(Direction.N).apply(Instruction.L).dir, `is`(Direction.W))
        assertThat(newRobotWith(Direction.W).apply(Instruction.L).dir, `is`(Direction.S))
        assertThat(newRobotWith(Direction.S).apply(Instruction.L).dir, `is`(Direction.E))
    }

    @Test
    fun `robot instructed to move right changes direction`() {
        assertThat(newRobotWith(Direction.E).apply(Instruction.R).dir, `is`(Direction.S))
        assertThat(newRobotWith(Direction.N).apply(Instruction.R).dir, `is`(Direction.E))
        assertThat(newRobotWith(Direction.W).apply(Instruction.R).dir, `is`(Direction.N))
        assertThat(newRobotWith(Direction.S).apply(Instruction.R).dir, `is`(Direction.W))
    }

    private fun newRobotWith(currentDir: Direction) = Robot(0, 0, dir = currentDir)
}