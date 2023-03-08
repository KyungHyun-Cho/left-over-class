package `dongyeon-lee`.`230308`

/* 징검다리 */
class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0
        val mRocks = rocks.sorted().let {
            it.mapIndexed { index, rock ->
             if (index == 0) rock else rock - it[index.dec()]
            }
        }
        var min = 1
        var max = 1_000_000_000
        while (min <= max) {
            val mid = (min + max) / 2
            var distAcc = 0
            var count = 0
            mRocks.forEach {
                distAcc += it
                if (distAcc < mid) count ++
                else distAcc = 0
            }
            if (n >= count) {
                answer = mid
                min = mid + 1
            } else {
                max = mid - 1
            }
        }
        return answer
    }
}