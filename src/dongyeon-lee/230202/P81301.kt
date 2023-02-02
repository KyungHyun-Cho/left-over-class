package `dongyeon-lee`.`230202`

class Solution {
    fun solution(s: String) =
        listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight" , "nine").let { numList ->
            numList.foldIndexed(s) { index, acc, str ->
                acc.replace(str, index.toString())
            }
        }.toInt()
}