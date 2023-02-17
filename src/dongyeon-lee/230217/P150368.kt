package `dongyeon-lee`.`230217`

import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray) =
        progresses.zip(speeds) { progress, speed ->
            ceil((100 - progress).toDouble() / speed).toInt()
        }.let { days ->
            var prev = 0
            days.mapIndexed { index, day ->
                if (index == 0 || day > prev) day.also { prev = it } else prev
            }
        }.groupBy { it }.map { it.value.size }
}