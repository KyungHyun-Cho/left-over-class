package `jaeguk-cho`.`모음사전`

/**
 * @author Jaeguk Cho
 */

class `모음사전` {
    val vowels = listOf('A', 'E', 'I', 'O', 'U')

    fun getStringByLength(length: Int, prefix: String = ""): List<String> {
        if (length == 0) return listOf(prefix)
        return vowels.flatMap { getStringByLength(length - 1, prefix + it) }
    }

    fun solution(word: String) = (1..5).flatMap { getStringByLength(it) }.sorted().indexOf(word) + 1
}
