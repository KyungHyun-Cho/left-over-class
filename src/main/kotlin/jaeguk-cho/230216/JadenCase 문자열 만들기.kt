package `jaeguk-cho`.`230216`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(s: String) = s.split(' ').joinToString(" ") { it.lowercase().capitalize() }
}
