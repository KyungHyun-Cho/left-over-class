package `dongyeon-lee`.`230201`

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray =
        (6 - (lottos.count { it !in win_nums })).let { intArrayOf(calc(it + lottos.count { it == 0 }), calc(it)) }
    fun calc(score: Int) = if (score <= 1) 6 else 7 - score
}