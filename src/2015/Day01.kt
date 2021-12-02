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
        return -1
    }

    // test if implementation meets criteria from the description, like:
    check(part1("(())".toCharArray()) == 0)
    check(part1("()()".toCharArray()) == 0)
    check(part1("(((".toCharArray()) == 3)
    check(part1("(()(()(".toCharArray()) == 3)
    check(part1("))(((((".toCharArray()) == 3)
    check(part1("())".toCharArray()) == -1)
    check(part1("))(".toCharArray()) == -1)
    check(part1(")))".toCharArray()) == -3)
    check(part1(")())())".toCharArray()) == -3)

    check(part2(")".toCharArray()) == 1)
    check(part2("()())".toCharArray()) == 5)

    val input = readInputText("Day01").toCharArray()
    println(part1(input))
    println(part2(input))
}
