package `2021`

fun main() {
    fun mostCommon(input: List<List<Int>>): String {
        val data = hashMapOf<Int, Pair<Int, Int>>()
        input.forEach { line ->
            line.forEachIndexed { i, char ->
                if (data[i] == null) { // If null, set default assignment
                    data[i] = Pair(0, 0)
                }
                val pair = data[i]
                val first = if (char == 0) pair!!.first + 1 else pair!!.first
                val second = if (char == 1) pair.second + 1 else pair.second
                data[i] = Pair(first, second)
            }
        }
        var mostCommon = ""
        data.values.forEach { value -> mostCommon += if (value.first > value.second) "0" else "1" }
        return mostCommon
    }

    fun invert(input: String): String {
        return input.map { char -> if (char == '0') "1" else "0" }.joinToString("")
    }

    fun getCriteria(input: MutableList<List<Int>>, start: Int, most: Boolean): String {
        val droppedLines: MutableList<List<Int>> = mutableListOf()
        val mostCommon = (if (most) mostCommon(input) else invert(mostCommon(input))).split("").filter { it2 -> it2.isNotEmpty() }.map { it3 -> it3.toInt() }
        val mostCommonChar = mostCommon[start]
        input.forEach { line ->
            val char = line[start]
            if (char.toString() != mostCommonChar.toString()) {
                droppedLines.add(line)
            }
        }
        input.removeAll(droppedLines)
        return if (input.size > 1) {
            getCriteria(input, start + 1, most)
        } else {
            val result = input[0]
            result.joinToString("") { it.toString() }
        }
    }

    fun part1(input: List<List<Int>>): Int {
        val gamma = mostCommon(input)
        val epsilon = invert(gamma)
        return (gamma.toInt(2) * epsilon.toInt(2))
    }

    fun part2(input: List<List<Int>>): Int {
        val oxygen = getCriteria(input.toMutableList(), 0, true)
        val carbonDioxide = getCriteria(input.toMutableList(), 0, false)
        return (oxygen.toInt(2) * carbonDioxide.toInt(2))
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test").map { it.split("").filter { it2 -> it2.isNotEmpty() }.map { it3 -> it3.toInt() } }
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03").map { it.split("").filter { it2 -> it2.isNotEmpty() }.map { it3 -> it3.toInt() } }
    println(part1(input))
    println(part2(input))
}
