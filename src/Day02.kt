fun main() {
    val shapeValues = mapOf("X" to 1, "Y" to 2, "Z" to 3, "A" to 1, "B" to 2, "C" to 3)

    fun part1(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val (opponent, mine) = line.split(" ")

            score += shapeValues.getOrDefault(mine, 0)
            val pairing = opponent + mine

            if (pairing in listOf("AX", "BY", "CZ")) {
                score += 3
            } else if (pairing in arrayOf("CX", "AY", "BZ")) {
                score += 6
            }
        }
        return score
    }

    val loseAgainst = mapOf("A" to "C", "B" to "A", "C" to "B")
    val winAgainst = mapOf("A" to "B", "B" to "C", "C" to "A")


    fun part2(input: List<String>): Int {
        var score = 0
        for (line in input) {
            val (opponent, outcome) = line.split(" ")
            val mine: String
            if (outcome.equals("X")) {
                mine = loseAgainst.get(opponent)!!
            } else if (outcome.equals("Y")) {
                mine = opponent
            } else {
                mine = winAgainst.get(opponent)!!
            }

            score += shapeValues.getOrDefault(mine, 0)
            val pairing = opponent + mine

            if (pairing in listOf("AA", "BB", "CC")) {
                score += 3
            } else if (pairing in arrayOf("CA", "AB", "BC")) {
                score += 6
            }
        }
        return score
    }

    val testInput = readInput("Day02_test_input")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02_input")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
