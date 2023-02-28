package `dongyeon-lee`.`230223`

/* 모음 사전 */
class Solution {
    val moums = listOf('A', 'E', 'I', 'O', 'U')
    fun solution(word: String) =  (1..5).runningReduce { acc, _ -> acc * 5 + 1 }.reversed().zip(word.toList()) { w, c -> w * moums.indexOf(c) }.sum() + word.length
}