package `jaeguk-cho`.`230206`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val time = MutableList(1450) { 0 }
        book_time.forEach { (s, e) ->
            time[s.split(':').let { it[0].toInt() * 60 + it[1].toInt() }]++
            time[e.split(':').let { it[0].toInt() * 60 + it[1].toInt() + 10 }]--
        }

        return time.runningReduce(Int::plus).maxOf { it }
    }
}
