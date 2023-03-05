package `jaeguk-cho`.`230301`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(brown: Int, yellow: Int) =
        with(brown + yellow) { (1..this).first { (this / it - 2) * (it - 2) == yellow }.let { listOf(this / it, it) } }
}
