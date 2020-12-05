class TreeMap(mapInput: String) {
    private val rows: List<String> = mapInput.split('\n').map { row -> row.trim()}
    val length: Int = rows.size
    private val width: Int = rows[0].length


    fun isTree(column: Int, row: Int): Boolean {
        val wrappedColumn = column % width
        return rows[row].toCharArray()[wrappedColumn] == '#'
    }

    fun print() {
        for(row in rows){
            println(row)
        }
    }
}