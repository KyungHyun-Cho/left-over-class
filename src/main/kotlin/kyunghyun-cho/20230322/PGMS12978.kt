package `kyunghyun-cho`.`20230322`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    listOf(
        Triple(5,
            arrayOf(intArrayOf(1, 2, 1),
                intArrayOf(2, 3, 3),
                intArrayOf(5, 2, 2),
                intArrayOf(1, 4, 2),
                intArrayOf(5, 3, 1),
                intArrayOf(5, 4, 2)),
            3),
        Triple(6,
            arrayOf(intArrayOf(1, 2, 1),
                intArrayOf(1, 3, 2),
                intArrayOf(2, 3, 2),
                intArrayOf(3, 4, 3),
                intArrayOf(3, 5, 2),
                intArrayOf(3, 5, 3),
                intArrayOf(5, 6, 1)),
            4)
    ).map { solution(it.first, it.second, it.third) }.also { println(it) }
}

const val INF = 123456789
fun solution(N: Int, road: Array<IntArray>, k: Int): Int {

    val map = Array(N + 1) { IntArray(N + 1) { INF } }.apply {
        road.forEach { (from, to, dist) ->
            this[from][to] = this[from][to].coerceAtMost(dist)
            this[to][from] = this[to][from].coerceAtMost(dist)
        }
    }

    (1..N).forEach { stop ->
        (1..N).forEach { from ->
            (1..N).forEach { to ->
                if(map[from][stop] + map[stop][to] < map[from][to]) map[from][to] = map[from][stop] + map[stop][to]
            }
        }
    }

    return map[1].filterIndexed { index, i -> index != 1 && i <= k }.count() + 1
}
