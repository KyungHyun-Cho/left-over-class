package `jaeguk-cho`.`230202`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(s: String) = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        .foldIndexed(s) { num, ans, word -> ans.replace(word, "$num") }.toInt()
}
