package `kyunghyun-cho`.`20230221`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    //val citations = intArrayOf(3, 0, 6, 1, 5) // 3
    val citations = intArrayOf(6,6,6,6,6) // 5

    println(solution(citations))
}

fun solution(citations: IntArray) =
    (0..citations.size)
        .last { citation -> citations.count { it >= citation } >= citation  }

