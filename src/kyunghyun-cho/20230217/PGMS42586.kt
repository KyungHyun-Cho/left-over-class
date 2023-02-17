package `kyunghyun-cho`.`20230217`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val (progresses, speeds) = intArrayOf(95, 90, 99, 99, 80, 99) to intArrayOf(1, 1, 1, 1, 1, 1) // 1, 3, 2
    //val (progresses, speeds) = intArrayOf(93, 30, 55) to intArrayOf(1, 30, 5) // 2, 1
    println(solution(progresses, speeds))
}

fun solution(progresses: IntArray, speeds: IntArray): List<Int> {
    var lastMax = 0
    return progresses.zip(speeds) { p, s -> ((100 - p) + s - 1) / s }
        .fold(mutableListOf()) { acc, value ->
            acc.apply {
                if (value > lastMax) this.add(1).also { lastMax = value }
                else this[acc.lastIndex]++
            }
        }
}
