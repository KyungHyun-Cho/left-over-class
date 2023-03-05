package `jaeguk-cho`.`230201`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): List<Int> {
        val min = 7 - lottos.count { it in win_nums }
        val max = min - lottos.count { it == 0 }

        return listOf(max, min).map { it.coerceAtMost(6) }
    }
}
