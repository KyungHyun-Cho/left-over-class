package `dongyeon-lee`.`230219`

/* H-INDEX */
class Solution {
    fun solution(citations: IntArray) = (1..(citations.maxOrNull() ?: 0)).maxOfOrNull { citation ->
        val isCountOverCitation = citations.count { it >= citation } >= citation
        if (isCountOverCitation) citation else 0
    } ?: 0
}