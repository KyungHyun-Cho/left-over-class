class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        val one = listOf(1, 2, 3, 4, 5)
        val two = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        val three = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        return answers.mapIndexed { index, ans ->
            listOf(one, two, three).map {
                (index % it.size).let { cursor ->
                    if (it[cursor] == ans) 1 else 0
                }
            }
        }.reduce { acc, ints ->
            acc.mapIndexed { index, i ->
                acc[index] + ints[index]
            }
        }.let {
            val max = it.maxOrNull()
            it.mapIndexed { index, score ->
                index.inc().takeIf { score == max }
            }.filterNotNull()
        }.toIntArray()
    }
}