package `dongyeon-lee`.`230309`

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0

        var l = 0
        var r = 200_000_000

        fun check(mid: Int): Boolean {
            var gap = 0
            stones.forEach { stone ->
                gap++
                if (stone >= mid ) {
                    gap = 0
                }

                if (gap >= k) return false
            }
            return true
        }

        while (l <= r) {
            val mid = (l + r) / 2

            if (check(mid)) {
                answer = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return answer
    }
}