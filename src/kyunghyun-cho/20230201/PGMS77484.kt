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
    val minWinCnt = lottos.count { it in win_nums }
    val maxWinCnt = minWinCnt + lottos.count { it == 0 }

    return listOf(maxWinCnt, minWinCnt).map { it.toGrade() }
}

fun Int.toGrade(): Int {
    return when(this){
        6 -> 1
        5 -> 2
        4 -> 3
        3 -> 4
        2 -> 5
        else -> 6
    }
}
