package `2021`

fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        var lastLine = 0
        for (line in input) {
            val lineInt = line.toInt()
            if (lineInt > lastLine) {
                count++
            }
            lastLine = lineInt
        }
        return count - 1
    }

    fun part2(input: List<String>): Int {
        var count = 0
        var sum = 0
        var lastSum = 0
        val data = mutableListOf<Int>()
        for (line in input) {
            val lineInt = line.toInt()
            sum += lineInt
            data.add(lineInt)
            if (data.size == 4) {
                sum -= data[0]
                data.removeFirst()
                if (sum > lastSum) {
                    count++
                }
                lastSum = sum
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
