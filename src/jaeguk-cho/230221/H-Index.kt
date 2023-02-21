package `jaeguk-cho`.`H-Index`

/**
 * @author Jaeguk Cho
 */

class `H-Index` {
    fun solution(citations: IntArray): Int {
        return (1..citations.size).maxOf {
            if (citations.count { c -> c >= it } >= it) it else 0
        }
    }
}
