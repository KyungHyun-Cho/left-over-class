package `jaeguk-cho`.`호텔 대실`

/**
 * @author Jaeguk Cho
 */

class `호텔 대실` {
    fun solution(book_time: Array<Array<String>>): Int {
        val time = MutableList(2400) { 0 }
        book_time.forEach { (s, e) ->
            time[s.filter { it != ':' }.toInt()]++
            time[e.filter { it != ':' }.toInt() + 10]--
        }

        return time.runningReduce(Int::plus).maxOf { it }
    }
}
