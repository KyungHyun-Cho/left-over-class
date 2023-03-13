package `dongyeon-lee`.`230313`

/* 덧칠하기 */
class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 0
        if (m == 1) return section.size
        var cursor = -1
        section.forEach { sec ->
            if (sec <= cursor) return@forEach
            answer++
            cursor = sec + m.dec().coerceAtLeast(1)
        }
        return answer
    }
}