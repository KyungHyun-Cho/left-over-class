package `kyunghyun-cho`.`20230320`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    listOf(
        arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH") to intArrayOf(2, 3, 4),
        arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD") to intArrayOf(2, 3, 5),
        arrayOf("XYZ", "XWY", "WXA") to intArrayOf(2, 3, 4),
    ).map { solution(it.first, it.second) }.also { println(it) }
}

fun solution(orders: Array<String>, course: IntArray) =
    course.asSequence().flatMap{ courseCnt ->
        orders.map { it.toCharArray().sortedArray() }
            .flatMap { pick(it, courseCnt) }
    }.groupingBy { it }.eachCount().filter { it.value >= 2 }
        .let { map ->
            val maxValueByKeyLength = map.map { it.key.length to it.value }.sortedBy { it.second }.associate { it }
            map.filter { it.value == maxValueByKeyLength[it.key.length] }.keys.sorted()
        }

fun pick(order: CharArray, cnt: Int, idx: Int = 0, picked: MutableList<Char> = mutableListOf()): Set<String> {
    if (order.size < cnt) return emptySet()
    else if (order.size == cnt) return setOf(order.joinToString(""))

    val answer = mutableSetOf<String>()
    if (picked.size == cnt) return setOf(picked.joinToString(""))

    (idx until order.size).forEach {
        picked.add(order[it])
        answer.addAll(pick(order, cnt, it + 1, picked))
        picked.removeLast()
    }

    return answer
}
