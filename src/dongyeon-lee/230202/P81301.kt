package `dongyeon-lee`.`230202`

class Solution {
    fun solution(s: String) =
        listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight" , "nine").let { numList ->
            numList.reduceIndexed { index, acc, str ->
                val target = if (index == 1) s else acc
                target.replace(str, index.toString())
            }.replace(numList.first(), "0")
        }.toInt()
}