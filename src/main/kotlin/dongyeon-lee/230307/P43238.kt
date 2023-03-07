package `dongyeon-lee`.`230307`

/* 킹국갓사 */
class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0

        var min: Long = 1
        var max: Long = n.toLong() * times.maxOrNull()!!
        while (min <= max) {
            val mid = (min + max) / 2
            val people = times.fold(0L) { acc, time -> acc + (mid / time) }
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
