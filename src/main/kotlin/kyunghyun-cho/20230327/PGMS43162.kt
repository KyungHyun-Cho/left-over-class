package `kyunghyun-cho`.`20230327`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    listOf(3 to arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)),
        3 to arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1)))
        .map { solution(it.first, it.second) }.let { println(it) }
}

fun solution(n: Int, computers: Array<IntArray>): Int {
    val INF = 987654321
    val set = mutableSetOf<Int>().apply { this.addAll(0 until n) }
    val map = computers.map { computer -> computer.map { if (it == 0) INF else 0 }.toMutableList() }
    var answer = 0

    (0 until n).forEach { stop ->
        (0 until n).forEach { from ->
            (0 until n).forEach { to ->
                if (map[from][stop] + map[stop][to] < map[from][to]) map[from][to] = map[from][stop] + map[stop][to]
            }
        }
    }

    while (set.isNotEmpty()) {
        set.removeAll(map[set.first()].mapIndexed { index, i -> if (i == INF) 0 else index })
        answer++
    }
    return answer
}
