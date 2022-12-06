fun main() {
    fun part1(input: List<String>): Int {
        var highest = 0
        var currentCounter = 0
        for (line in input) {
            if (line.isNotEmpty()) {
                currentCounter += line.toInt()
            } else {
                if (highest < currentCounter) {
                    highest = currentCounter
                }
                currentCounter = 0
            }
        }
        return highest
    }

    fun part2(input: List<String>): Int {
        val numberList = ArrayList<Int>()
        var currentCounter = 0
        for (line in input) {
            if (line.isNotEmpty()) {
                currentCounter += line.toInt()
            } else {
                numberList.add(currentCounter)
                currentCounter = 0
            }
        }
        numberList.add(currentCounter)

        return numberList.sortedDescending().take(3).sum()
    }

    val testInput = readInput("Day01_test_input")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01_input")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
