package `dongyeon-lee`.`230307`

/* 킹국갓사 */
class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer = 0L

        var min = 1L
        var max = n.toLong() * (times.maxOrNull() ?: 0)
        while (min <= max) {
            val mid = (min + max) / 2
            val people = times.sumOf { mid / it }
            if (people < n) {
                min = mid + 1
            } else {
                answer = mid
                max = mid - 1
            }
        }
        return answer
    }
}
