package `jaeguk-cho`.`H-Index`

/**
 * @author Jaeguk Cho
 */

class `H-Index` {
    fun solution(citations: IntArray) = (0..citations.size).last { h -> citations.count { it >= h } >= h }
}
