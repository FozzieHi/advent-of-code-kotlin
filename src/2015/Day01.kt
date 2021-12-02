package `2015`

fun main() {
    fun part1(input: CharArray): Int {
        var floor = 0
        input.forEach { char ->
            when (char) {
                '(' -> floor++
                ')' -> floor--
            }
        }
        return floor
    }

    fun part2(input: CharArray): Int {
        var floor = 0
        input.forEachIndexed { i, char ->
            when (char) {
                '(' -> floor++
                ')' -> floor--
            }
            if (floor < 0) {
                return i + 1
            }
        }
        return floor
    }

    // test if implementation meets criteria from the description, like:
    val testInputPart1 = readInputText("Day01Part1_test").toCharArray()
    val testInputPart2 = readInputText("Day01Part2_test").toCharArray()
    check(part1(testInputPart1) == 3)
    check(part2(testInputPart2) == 5)

    val input = readInputText("Day01").toCharArray()
    println(part1(input))
    println(part2(input))
}
