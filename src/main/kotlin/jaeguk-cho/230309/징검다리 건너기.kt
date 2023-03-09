package `jaeguk-cho`.`230309`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var (l, r) = 1 to 200000000
        var ans = (1..r).random()

        fun check(m: Int) = stones.toList().windowed(k).none { window -> window.all { it < m } }

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
