package `kyunghyun-cho`.`230206`

/**
 * @author Kyunghyun Cho
 */
fun main() {
    val book_time = arrayOf(arrayOf("15:00", "17:00"),
        arrayOf("16:40", "18:20"),
        arrayOf("14:20", "15:20"),
        arrayOf("14:10", "19:20"),
        arrayOf("18:20", "21:20"))
    //val book_time = arrayOf(arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"))

    println(solution(book_time))
    println(solution2(book_time))
}

private const val CLEANING_TIME = 10

fun solution(book_time: Array<Array<String>>): Int {
    val roomEndTimes = mutableListOf<Int>()
    val intTimeList = book_time.map { it.toIntTimePair() }.sortedBy { it.first }
    intTimeList.forEach { (start, end) ->
        val minRoomEndTime = roomEndTimes.minOrNull()
        if (minRoomEndTime == null || minRoomEndTime > start) {
            roomEndTimes.add(end)
        } else {
            roomEndTimes.remove(minRoomEndTime)
            roomEndTimes.add(end)
        }
    }
    return roomEndTimes.size
}

fun solution2(book_time: Array<Array<String>>): Int {
    val intTimeRangeList = book_time.map { it.toIntTimeRange() }
    return (0 until 60 * 24).maxOf { time -> intTimeRangeList.count { it.contains(time) } }
}

private fun Array<String>.toIntTimePair() = this[0].toIntTime() to this[1].toIntTime() + CLEANING_TIME
private fun Array<String>.toIntTimeRange() = this[0].toIntTime() until this[1].toIntTime() + CLEANING_TIME
private fun String.toIntTime() = this.split(":").let { it[0].toInt() * 60 + it[1].toInt() }
