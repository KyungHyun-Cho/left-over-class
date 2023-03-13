package `dongyeon-lee`.`230313`

/* 덧칠하기 */
class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 0
        if (m == 1) return section.first()
        section.fold(-1) { cursor, sec ->
            if (sec > cursor) {
                answer++
                sec + m.dec().coerceAtLeast(1)
            } else cursor
        }
        return answer
    }
}