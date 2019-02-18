package rb.robogrid

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RobotTest {

    class MyTestGrid : Grid {
        override fun accept(currentPos: Position): Position {
            return currentPos
        }

    }

    @Test
    fun `robot string representation matches its current position and direction separate by one space`() {
        // test passes if the code compiles
        assertThat(Robot(Position(1, 1), Direction.E, MyTestGrid()).toString(), `is`("1 1 E"))
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
        assertThat(robot.position, `is`(Position(10, 8)))
    }

    @Test
    fun `robot moving forward when at east increases x by 1 and keeps y as is`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.E).apply(Instruction.F)
        assertThat(robot.position, `is`(Position(11, 7)))
    }


    @Test
    fun `robot moving forward when at south decreases y by 1 and keeps x as is`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.S).apply(Instruction.F)
        assertThat(robot.position, `is`(Position(10, 6)))
    }

    @Test
    fun `robot moving forward when at west decreases x by 1 and keeps y as is`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.W).apply(Instruction.F)
        assertThat(robot.position, `is`(Position(9, 7)))
    }

    @Test
    fun `robot wont change position when at west and applying left`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.W).apply(Instruction.L)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot wont change position when at west and applying right`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.W).apply(Instruction.R)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot wont change position when at east and applying left`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.E).apply(Instruction.L)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot wont change position when at east and applying right`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.E).apply(Instruction.R)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot wont change position when at north and applying left`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.N).apply(Instruction.L)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot wont change position when at north and applying right`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.N).apply(Instruction.R)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot wont change position when at south and applying left`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.S).apply(Instruction.L)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot wont change position when at south and applying right`() {
        val robot = newRobotWith(current_x = 10, current_y = 7, currentDir = Direction.S).apply(Instruction.R)
        assertThat(robot.position, `is`(Position(10, 7)))
    }

    @Test
    fun `robot delegates to grid acceptance of new position`() {
        // next time we'll use mockito
        class FooGrid : Grid {
            override fun accept(currentPos: Position) = Position(11, 22)
        }
        val robot = newRobotWith(currentGrid = FooGrid()).apply(Instruction.F)
        assertThat(robot.position, `is`(Position(11, 22)))
    }

    private fun newRobotWith(current_x: Int = 10,
                             current_y: Int = 10,
                             currentDir: Direction = Direction.N, currentGrid: Grid = MyTestGrid()) = Robot(Position(x = current_x, y = current_y), dir = currentDir, grid = currentGrid)
}