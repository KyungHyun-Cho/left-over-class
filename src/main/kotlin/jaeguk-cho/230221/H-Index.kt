package `jaeguk-cho`.`230221`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(citations: IntArray) = (0..citations.size).last { h -> citations.count { it >= h } >= h }
}
