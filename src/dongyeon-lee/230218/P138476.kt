package `dongyeon-lee`.`230218`

/* 귤  고르기 */
class Solution {
    fun solution(k: Int, tangerine: IntArray) =
        tangerine.groupBy { it }
            .map { it.value.size }
            .sortedByDescending { it }
            .runningFold(0, Int::plus)
            .indexOfFirst { k <= it }
}