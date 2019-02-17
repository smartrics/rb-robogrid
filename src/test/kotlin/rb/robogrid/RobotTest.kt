package rb.robogrid

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RobotTest {

    @Test
    fun `robot string representation matches its current position and direction separate by one space`() {
        // test passes if the code compiles
        assertThat(Robot(1, 1, Direction.E).toString(), `is`("1 1 E"))
    }

}