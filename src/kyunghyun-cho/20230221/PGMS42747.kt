package `kyunghyun-cho`.`20230221`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val citations = intArrayOf(3, 0, 6, 1, 5) // 3
    println(solution(citations))
    println(fastSolution(citations))
}

fun solution(citations: IntArray) =
    citations.toSet()
        .filter { citation -> citations.count { it >= citation } == citations.count { it <= citation } }
        .maxOrNull()!!

fun fastSolution(citations: IntArray) =
    citations.toSortedSet()
        .last { citation -> citations.count { it >= citation } == citations.count { it <= citation } }

