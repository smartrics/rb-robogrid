package rb.robogrid

import org.junit.*

class RobotTest {

    @Test
    fun `robot is initialised with initial position and direction`() {
        // test passes if the code compiles
        Robot(1, 1, Direction.E)
    }

}