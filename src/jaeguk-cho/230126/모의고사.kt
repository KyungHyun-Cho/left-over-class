package `jaeguk-cho`.`모의고사`

/**
 * @author Jaeguk Cho
 */

class `모의고사` {
    fun Sequence<Int>.repeat() = sequence { while (true) yieldAll(this@repeat) }

    fun solution(answers: IntArray): List<Int> {
        val ans = listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(2, 1, 2, 3, 2, 4, 2, 5),
            listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        ).map { it.asSequence().repeat().take(answers.size).zip(answers.asSequence(), Int::equals).count { it } }

        val max = ans.maxOf { it }
        return ans.withIndex().filter { it.value == max }.map { it.index + 1 }
    }
}
