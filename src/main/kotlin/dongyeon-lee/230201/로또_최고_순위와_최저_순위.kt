package `dongyeon-lee`.`230201`

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray) =
        lottos.count { it in win_nums }.let { minScore ->
            val maxScore = minScore + lottos.count { it == 0 }
            listOf(maxScore, minScore).map { it.toRank() }
        }
    fun Int.toRank() = 7 - this.coerceAtLeast(1)
}