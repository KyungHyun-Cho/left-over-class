package `kyunghyun-cho`.`20230218`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val (k, tangerine) = 6 to intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    println(solution(k, tangerine))
}

fun solution(k: Int, tangerine: IntArray) =
    tangerine.groupBy { it }
        .map { it.value.size }
        .sortedDescending()
        .runningReduce(Int::plus)
        .indexOfFirst { k <= it } + 1
