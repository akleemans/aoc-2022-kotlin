fun main() {

    fun part1(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val (a, b) = line.split(",")
            val (a1, a2) = a.split("-").map { s -> s.toInt() }
            val (b1, b2) = b.split("-").map { s -> s.toInt() }
            if ((a1 >= b1 && a2 <= b2) || (a1 <= b1 && a2 >= b2)) {
                score += 1
            }
        }
        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val (a, b) = line.split(",")
            val (a1, a2) = a.split("-").map { s -> s.toInt() }
            val (b1, b2) = b.split("-").map { s -> s.toInt() }
            if (b1 in a1..a2 || a1 in b1..b2) {
                score += 1
            }
        }
        return score
    }

    val testInput = readInput("Day04_test_input")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04_input")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
