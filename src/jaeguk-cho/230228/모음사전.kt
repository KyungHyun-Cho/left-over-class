package `jaeguk-cho`.`모음사전`

/**
 * @author Jaeguk Cho
 */

class `모음사전` {
    val vowels = listOf('A', 'E', 'I', 'O', 'U')

    fun getByLength(length: Int, prefix: String = ""): List<String> {
        if (length == 0) return listOf(prefix)
        return vowels.flatMap { getByLength(length - 1, prefix + it) }
    }

    fun getByLengthLessThanEqual(length: Int): List<String> {
        if (length == 0) return listOf()
        return getByLength(length) + getByLengthLessThanEqual(length - 1)
    }

    fun solution(word: String) = getByLengthLessThanEqual(5).sorted().indexOf(word) + 1
}
