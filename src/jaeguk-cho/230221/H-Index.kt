package `jaeguk-cho`.`H-Index`

/**
 * @author Jaeguk Cho
 */

class `H-Index` {
    fun solution(citations: IntArray) = (1..citations.size)
        .maxOf { h -> h.takeIf { citations.count { it >= h } >= h } ?: 0 }
}
