package `dongyeon-lee`.`230309`

/* 징검다리 건너기 */
class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0

        var l = 0
        var r = 200_000_000

        fun check(mid: Int): Boolean {
            var gap = 0
            stones.forEach { stone ->
                if (stone <= mid && gap <= k) {
                    gap = 0
                } else return false
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