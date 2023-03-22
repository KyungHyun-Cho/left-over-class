package `jaeguk-cho`.`230308`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        val rocks = listOf(*rocks.toTypedArray(), 1, distance).sorted()
        var (l, r) = 1 to 999999999
        var ans = (l..r).random()

        fun check(m: Int): Boolean {
            var cnt = 0

            rocks.reduce { prev, cur ->
                if (cur - prev < m) {
                    cnt++; prev
                } else {
                    cur
                }
            }

            return cnt <= n
        }

        while (l <= r) {
            val m = (l + r) / 2

            if (check(m)) {
                ans = m
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return ans
    }
}
