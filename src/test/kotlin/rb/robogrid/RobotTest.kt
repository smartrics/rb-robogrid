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
        assertThat(newRobotWith(currentDir = Direction.E).apply(Instruction.L).dir, `is`(Direction.N))
        assertThat(newRobotWith(currentDir = Direction.N).apply(Instruction.L).dir, `is`(Direction.W))
        assertThat(newRobotWith(currentDir = Direction.W).apply(Instruction.L).dir, `is`(Direction.S))
        assertThat(newRobotWith(currentDir = Direction.S).apply(Instruction.L).dir, `is`(Direction.E))
    }

    @Test
    fun `robot instructed to move right changes direction`() {
        assertThat(newRobotWith(currentDir = Direction.E).apply(Instruction.R).dir, `is`(Direction.S))
        assertThat(newRobotWith(currentDir = Direction.N).apply(Instruction.R).dir, `is`(Direction.E))
        assertThat(newRobotWith(currentDir = Direction.W).apply(Instruction.R).dir, `is`(Direction.N))
        assertThat(newRobotWith(currentDir = Direction.S).apply(Instruction.R).dir, `is`(Direction.W))
    }

    @Test
    fun `robot instructed to move forward won't change direction`() {
        assertThat(newRobotWith(currentDir = Direction.E).apply(Instruction.F).dir, `is`(Direction.E))
        assertThat(newRobotWith(currentDir = Direction.N).apply(Instruction.F).dir, `is`(Direction.N))
        assertThat(newRobotWith(currentDir = Direction.W).apply(Instruction.F).dir, `is`(Direction.W))
        assertThat(newRobotWith(currentDir = Direction.S).apply(Instruction.F).dir, `is`(Direction.S))
    }

    @Test
    fun `robot moving forward when at north increases y by 1 and keeps x as is`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.N).apply(Instruction.F)
        assertThat(robot.x, `is`(10))
        assertThat(robot.y, `is`(8))
    }

    private fun newRobotWith(current_x: Int = 0,
                             current_y: Int = 0,
                             currentDir: Direction = Direction.N)
            = Robot(current_x, y = current_y, dir = currentDir)
}