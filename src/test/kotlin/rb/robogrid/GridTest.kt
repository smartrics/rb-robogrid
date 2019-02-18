package rb.robogrid

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class GridTest {

    @Test
    fun `a grid is initialised with width and height`() {
        val g = Grid(5, 3)

        assertThat(g.x_zero, `is`(0))
        assertThat(g.y_zero, `is`(0))
        assertThat(g.x_top, `is`(5))
        assertThat(g.y_top, `is`(3))
    }
}