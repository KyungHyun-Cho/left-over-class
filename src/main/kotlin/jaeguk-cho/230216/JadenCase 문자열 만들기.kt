package `jaeguk-cho`.`JadenCase 문자열 만들기`

/**
 * @author Jaeguk Cho
 */

class `JadenCase 문자열 만들기` {
    fun solution(s: String) = s.split(' ').joinToString(' ') { it.lowercase().capitalize() }
}
