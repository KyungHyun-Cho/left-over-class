package `kyunghyun-cho`.`20230313`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    // 2, 1, 4, 1, 3, 4, 5, 3
    val params = listOf(
        Triple(8, 4, intArrayOf(2, 3, 6)),
        Triple(5, 4, intArrayOf(1, 3)),
        Triple(4, 1, intArrayOf(1, 2, 3, 4)),
        Triple(8, 8, intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)),
        Triple(8, 3, intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)),
        Triple(14, 2, intArrayOf(3, 6, 9, 12)),
        Triple(20, 4, intArrayOf(1, 4, 8, 12, 16, 20)),
        Triple(20, 5, intArrayOf(1, 4, 8, 12, 16, 20)),
        )
    println(params.map { solution(it.first, it.second, it.third) })
    println(params.map { fastSolution(it.first, it.second, it.third) })
}

fun solution(n: Int, m: Int, section: IntArray): Int {
    val dq = ArrayDeque<Int>().apply { this.addAll(section.toList()) }
    var answer = 0
    while (dq.isNotEmpty()) {
        val polled = dq.removeFirst()
        answer++
        while (dq.isNotEmpty() && (dq.first() - polled) < m) {
            dq.removeFirst()
        }
    }
    return answer
}

fun fastSolution(n: Int, m: Int, section: IntArray): Int {
    var answer = 1
    var std = section.first()
    (1 until section.size).forEach {
        if(section[it] - std >= m){
            std = section[it]
            answer++
        }
    }
    return answer
}
