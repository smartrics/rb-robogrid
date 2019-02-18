package rb.robogrid

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class GridTest {

    @Test
    fun `a grid is initialised with width and height`() {
        val g = Grid(5, 3)
        assertThat(g.zero, `is`(Position(0, 0)))
        assertThat(g.top, `is`(Position(5, 3)))
    }
}