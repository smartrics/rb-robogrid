package rb.robogrid

import org.junit.Test
import java.lang.IllegalArgumentException

class PositionTest {


    @Test(expected = IllegalArgumentException::class)
    fun `x coordinate cannot be bigger than 50`() {
        Position(x = 51, y = 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `x coordinate cannot be smaller than 0`() {
        Position(x = -1, y = 0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `y coordinate cannot be bigger than 50`() {
        Position(x = 0, y = 51)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `y coordinate cannot be smaller than 0`() {
        Position(x = 0, y = -1)
    }

}