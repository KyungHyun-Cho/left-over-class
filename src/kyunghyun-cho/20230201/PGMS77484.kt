package `kyunghyun-cho`.`20230201`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val lottos = intArrayOf(44, 1, 0, 0, 31, 25)
    val win_nums = intArrayOf(31, 10, 45, 1, 6, 19)
    println(solution(lottos, win_nums)) // 3, 5
}

fun solution(lottos: IntArray, win_nums: IntArray): List<Int> {
    val (certain, uncertain) = lottos.partition { it != 0 }
    return certain.count { win_nums.contains(it) }.let { wonCnt ->
        val min = (7 - wonCnt).coerceAtMost(6)
        val max = (min - uncertain.size).coerceAtLeast(1)
        listOf(max, min)
    }
}
