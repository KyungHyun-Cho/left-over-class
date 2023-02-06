package `dongyeon-lee`.`230206`

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val timeRange = book_time.map { (start, end) ->
            start.toTime() until end.toTime() + 10
        }
        return (0 until 1440).maxOf { time -> timeRange.count { it.contains(time) } }
    }
    fun String.toTime() = split(":").let { (hour, min) ->
        hour.toInt() * 60 + min.toInt()
    }
}