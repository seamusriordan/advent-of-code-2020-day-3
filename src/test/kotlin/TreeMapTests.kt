import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TreeMapTests {
    @Test
    internal fun `one cell map returns length one`() {
        val map = TreeMap(".")

        assertEquals(1, map.length)
    }

    @Test
    internal fun `two row map returns length two`() {
        val map = TreeMap(".\n.")

        assertEquals(2, map.length)
    }

    @Test
    internal fun `two row map without trees returns no tree`() {
        val map = TreeMap(".\n.")

        assertFalse(map.isTree(0,1))
    }

    @Test
    internal fun `two row map with tree returns tree`() {
        val map = TreeMap(".\n#")

        assertTrue(map.isTree(0,1))
    }

    @Test
    internal fun `three row map with tree at bottom returns tree`() {
        val map = TreeMap(".\n.\n#")

        assertTrue(map.isTree(0,2))
    }

    @Test
    internal fun `two column map with tree returns tree`() {
        val map = TreeMap(".#")

        assertTrue(map.isTree(1,0))
    }

    @Test
    internal fun `two column map with tree returns tree when wrapping over`() {
        val map = TreeMap(".#")

        assertTrue(map.isTree(3,0))
    }
}