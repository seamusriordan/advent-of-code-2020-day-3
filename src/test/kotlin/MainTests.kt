import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTests {
    @Test
    internal fun `counts zero trees for one cell map`() {
        val map = TreeMap(".")

        assertEquals(0, countTrees(map, 0))
    }

    @Test
    internal fun `counts one tree for one column map with one tree zero slop`() {
        val map = TreeMap(".\n#")

        assertEquals(1, countTrees(map, 0))
    }

    @Test
    internal fun `counts one tree for 2x2 map slope 1 with one tree in far corner`() {
        val map = TreeMap("..\n.#")

        assertEquals(1, countTrees(map, 1))
    }
}