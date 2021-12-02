package `2021`

fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        input.forEach { line ->
            val regex = """^(forward|down|up) (\d)$""".toRegex()
            val (action, amount) = regex.find(line)?.destructured
                ?: error("Could not find action and amount from input.")
            when (action) {
                "forward" -> horizontal += amount.toInt()
                "down" -> depth += amount.toInt()
                "up" -> depth -= amount.toInt()
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        input.forEach { line ->
            val regex = """^(forward|down|up) (\d)$""".toRegex()
            val (action, amount) = regex.find(line)?.destructured
                ?: error("Could not find action and amount from input.")
            when (action) {
                "forward" -> {
                    horizontal += amount.toInt()
                    depth += aim * amount.toInt()
                }
                "down" -> aim += amount.toInt()
                "up" -> aim -= amount.toInt()
            }
        }
        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
