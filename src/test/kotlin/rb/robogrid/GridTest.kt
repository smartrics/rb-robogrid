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

    @Test
    fun `accepts a position and returns it if within boundaries`() {
        assertThat(Grid(5, 3).accept(Position(2, 2)), `is`(Position(2, 2)))
    }

    @Test
    fun `accepts a position and returns LOST if outside x or y boundaries`() {
        assertThat(Grid(5, 3).accept(Position(10, 2)), `is`(Position.LOST))
        assertThat(Grid(5, 3).accept(Position(3, 20)), `is`(Position.LOST))
    }

    @Test
    fun `accepts a LOST position and if already accepted as lost makes it scented`() {
        val grid = Grid(5, 3)
        val accept1 = grid.accept(Position(10, 2))
        val accept2 = grid.accept(Position(10, 2))
        assertThat(accept1.scented, `is`(false))
        assertThat(accept2.scented, `is`(true))
    }
}