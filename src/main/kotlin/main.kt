import java.io.File

fun main() {
    val input = File("src/main/resources/input.txt").readText()
    val map = TreeMap(input)

    map.print()

    println(countTrees(map, 3))

    val slopes: List<Pair<Int, Int>> = listOf(
        Pair(1, 1),
        Pair(3, 1),
        Pair(5, 1),
        Pair(7, 1),
        Pair(1, 2)
    )

    val counts: List<Long> = slopes.map {
        countTrees(map, it.first, it.second).toLong()
    }

    println(counts.reduce { a: Long, b:Long -> a*b })
}

fun countTrees(map: TreeMap, slope: Int, down: Int = 1): Int {
    return (0 until map.length).filter { i ->
        map.isTree(i * slope / down, i) && i % down == 0
    }.count()
}