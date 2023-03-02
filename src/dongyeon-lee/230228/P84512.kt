package `dongyeon-lee`.`230223`

/* 모음 사전 */
class Solution {
    val vowels = listOf('A', 'E', 'I', 'O', 'U')
    fun solution(word: String) =  (1..5).runningReduce { acc, _ -> acc * 5 + 1 }.reversed().zip(word.toList()) { w, c -> w * vowels.indexOf(c) }.sum() + word.length
}