package `dongyeon-lee`.`230219`

/* H-INDEX */
class Solution {
    fun solution(citations: IntArray) = (0..(citations.size)).last { citation ->
        citations.count { it >= citation } >= citation }
}