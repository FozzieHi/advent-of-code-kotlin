package `2015`

fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        input.forEach { line ->
            val (length, width, height) = line.split("x").map { it.toInt() }
            val extra = minOf(length * width, width * height, height * length)
            count += (2 * length * width) + (2 * width * height) + (2 * height * length) + extra
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        input.forEach { line ->
            val (length, width, height) = line.split("x").map { it.toInt() }
            val ribbon = 2 * minOf(length + width, width + height, height + length)
            val bow = length * width * height
            count += ribbon + bow
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    check(part1(listOf("2x3x4")) == 58)
    check(part1(listOf("1x1x10")) == 43)

    check(part2(listOf("2x3x4")) == 34)
    check(part2(listOf("1x1x10")) == 14)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
