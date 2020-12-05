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

    @Test
    internal fun `counts one tree for 3 column map slope 0 down 2 with all trees`() {
        val map = TreeMap(".\n#\n#")

        assertEquals(1, countTrees(map, 0, 2))
    }

    @Test
    internal fun `counts one tree for 3x2 column map slope 0 down 2 with all trees`() {
        val map = TreeMap("..\n##\n.#")

        assertEquals(1, countTrees(map, 1, 2))
    }

    @Test
    fun `example input`() {
        val input =
            "..##.......\r\n" +
                    "#...#...#..\r\n" +
                    ".#....#..#.\r\n" +
                    "..#.#...#.#\n" +
                    ".#...##..#.\r\n" +
                    "..#.##.....\r\n" +
                    ".#.#.#....#\r\n" +
                    ".#........#\r\n" +
                    "#.##...#...\r\n" +
                    "#...##....#\r\n" +
                    ".#..#...#.#"
        val map = TreeMap(input)


        map.print()

        assertEquals(7, countTrees(map, 3))
    }

    @Test
    fun `example input part 2`() {
        val input = "..##.......\r\n" +
                    "#...#...#..\r\n" +
                    ".#....#..#.\r\n" +
                    "..#.#...#.#\r\n" +
                    ".#...##..#.\r\n" +
                    "..#.##.....\r\n" +
                    ".#.#.#....#\r\n" +
                    ".#........#\r\n" +
                    "#.##...#...\r\n" +
                    "#...##....#\r\n" +
                    ".#..#...#.#"
        val map = TreeMap(input)
        val slopes: List<Pair<Int, Int>> = listOf(
            Pair(1, 1),
            Pair(3, 1),
            Pair(5, 1),
            Pair(7, 1),
            Pair(1, 2)
        );

        val counts = slopes.map {
            countTrees(map, it.first, it.second)
        }

        assertEquals(listOf(2, 7, 3, 4, 2), counts)
        assertEquals(336, counts.reduce { a: Int, b:Int -> a*b })

    }

}