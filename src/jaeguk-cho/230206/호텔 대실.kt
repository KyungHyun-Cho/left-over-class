package `jaeguk-cho`.`호텔 대실`

/**
 * @author Jaeguk Cho
 */

class `호텔 대실` {
    fun solution(book_time: Array<Array<String>>): Int {
        val time = MutableList(2400) { 0 }
        book_time.forEach {
            time[it[0].filter { it != ':' }.toInt()]++
            time[it[1].filter { it != ':' }.toInt()]--
        }

        return time.runningReduce(Int::plus).maxOf { it }
    }
}
