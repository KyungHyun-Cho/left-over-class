package `dongyeon-lee`.`230201`

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray) =
        (6 - (lottos.count { it !in win_nums })).let { minScore ->
            val maxScore = minScore + lottos.count { it == 0 }
            listOf(maxScore, minScore).map { it.toRank() }
        }
    fun Int.toRank() = if (this <= 1) 6 else 7 - this
}