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
}