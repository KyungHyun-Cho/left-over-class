package `jaeguk-cho`.`230228`

/**
 * @author Jaeguk Cho
 */

class Solution {
    val vowels = listOf('A', 'E', 'I', 'O', 'U')

    fun getStringByLength(length: Int, prefix: String = ""): List<String> {
        return listOf(prefix).takeIf { length == 0 } ?: vowels.flatMap { getStringByLength(length - 1, prefix + it) }
    }

    fun solution(word: String) = (1..5).flatMap { getStringByLength(it) }.sorted().indexOf(word) + 1
}
