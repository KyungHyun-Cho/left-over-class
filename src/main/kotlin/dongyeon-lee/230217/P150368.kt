package `dongyeon-lee`.`230217`

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray) =
        progresses.zip(speeds) { progress, speed -> ((100 - progress) + speed - 1) / speed }.let {days ->
            var prev = 0
            days.mapIndexed { index, day ->
                if (index == 0 || day > prev) day.also { prev = it } else prev
            }
        }.groupingBy { it }.eachCount().values
}