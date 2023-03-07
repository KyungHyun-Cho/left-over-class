package `jaeguk-cho`.`230307`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(n: Int, times: IntArray): Long {
        val immigrate = { m: Long -> n <= times.sumOf { m / it } }
        var ans = -1L
        var l = 1L
        var r = 1000000000000000000
        while (l <= r) {
            val m = (l + r) / 2

            if (immigrate(m)) {
                ans = m
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return ans
    }
}
