package `jaeguk-cho`.`230126`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun Sequence<Int>.repeat() = sequence { while (true) yieldAll(this@repeat) }

    fun solution(answers: IntArray) = listOf(
        listOf(1, 2, 3, 4, 5),
        listOf(2, 1, 2, 3, 2, 4, 2, 5),
        listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    ).map { it.asSequence().repeat().take(answers.size).zip(answers.asSequence(), Int::equals).count { it } }
        .let { score -> score.withIndex().filter { it.value == score.maxOf { it } }.map { it.index + 1 } }
}
