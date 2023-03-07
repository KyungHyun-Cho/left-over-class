package `kyunghyun-cho`.`20230307`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val n = 6
    val times = intArrayOf(7, 10) // 28
    println(solution(n, times))
}

fun solution(n: Int, times: IntArray): Long {
    var (low, high) = 0L to Long.MAX_VALUE/7L
    var answer = high
    while (low <= high) {
        val mid = (low + high) / 2L
        val ppl = times.sumOf { mid / it }
        if (ppl < n) {
            low = mid + 1
        } else{
            answer = kotlin.math.min(mid, answer)
            high = mid - 1
        }
    }

    return answer
}
