fun main() {
    val N = readln().toInt()
    val map = Array(N) { IntArray(N) }
    val isVisit = Array(N) { BooleanArray(N) }

    for(i in 0 until N) {
        map[i] = readln().map { it.toString().toInt() }.toIntArray()
    }

    val placeSizes = mutableListOf<Int>()

    fun findPlace(row: Int, col: Int): Int {
        if(row < 0 || row >= N || col < 0 || col >= N || isVisit[row][col] || map[row][col] == 0) {
            return 0
        }

        isVisit[row][col] = true

        return findPlace(row - 1, col) + findPlace(row + 1, col) + findPlace(row, col - 1) + findPlace(row, col + 1) + 1
    }

    for(i in 0 until N) {
        for(j in 0 until N) {
            if(map[i][j] == 1 && !isVisit[i][j]) {
                placeSizes.add(findPlace(i, j))
            }
        }
    }

    println(placeSizes.size)
    println(placeSizes.sorted().joinToString("\n"))
}
