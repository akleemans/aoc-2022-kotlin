fun main() {

    fun duplicateCount(text: String): Int {
        val invalid = ArrayList<Char>()

        for (i in text.indices) {
            val c = text[i].lowercaseChar()
            if (invalid.contains(c))
                continue

            for (j in i + 1 until text.length) {
                if (c == text[j].lowercaseChar()) {
                    invalid.add(c)
                    break
                }
            }
        }

        return invalid.size;
    }

    fun part1(input: List<String>): Int {
        val s = input.get(0)
        for (i in 4..s.length) {
            if (duplicateCount(s.substring(i - 4, i)) == 0) {
                return i;
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        val s = input.get(0)
        for (i in 14..s.length) {
            if (duplicateCount(s.substring(i - 14, i)) == 0) {
                return i;
            }
        }
        return 0
    }

    val testInput = readInput("Day06_test_input")
    check(part1(testInput) == 11)
    check(part2(testInput) == 26)

    val input = readInput("Day06_input")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
