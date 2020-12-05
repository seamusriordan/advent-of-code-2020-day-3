fun main() {
    println("Hello World!")
}

fun countTrees(map: TreeMap, slope: Int): Int {
    return (0 until map.length).filter { i ->
        map.isTree(i*slope, i)
    }.count()
}