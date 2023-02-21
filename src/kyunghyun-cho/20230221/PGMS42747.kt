package `kyunghyun-cho`.`20230221`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val citations = intArrayOf(3, 0, 6, 1, 5) // 3
    println(solution(citations))
}

fun solution(citations: IntArray): Int {
    return citations.toSet().filter { a -> citations.count { it >= a } == citations.count { it <= a } }.maxOrNull()!!
}
