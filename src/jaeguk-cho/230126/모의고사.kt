package `jaeguk-cho`.`모의고사`

/**
 * @author Jaeguk Cho
 */

class `모의고사` {
    fun solution(answers: IntArray): List<Int> {
        val seq1 = listOf(1, 2, 3, 4, 5)
        val seq2 = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        val seq3 = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val ans = mutableListOf(0, 0, 0)

        answers.forEachIndexed { i, q ->
            if (q == seq1[i % 5]) ans[0]++
            if (q == seq2[i % 8]) ans[1]++
            if (q == seq3[i % 10]) ans[2]++
        }

        println(ans)

        val max = ans.maxOf { it }
        return ans.withIndex().filter { it.value == max }.map { it.index + 1 }
    }
}
