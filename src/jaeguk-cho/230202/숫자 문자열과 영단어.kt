package `jaeguk-cho`.`숫자 문자열과 영단어`

/**
 * @author Jaeguk Cho
 */

class `숫자 문자열과 영단어` {
    fun solution(s: String) = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        .foldIndexed(s) { idx, s, word -> s.replace(word, idx.toString()) }.toInt()
}
