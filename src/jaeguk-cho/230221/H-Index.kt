package `jaeguk-cho`.`H-Index`

/**
 * @author Jaeguk Cho
 */

class `H-Index` {
    fun solution(citations: IntArray) = (1..citations.size)
        .filter { h -> citations.count { it >= h } >= h }.maxOf { it }
}
