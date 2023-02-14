package `kyunghyun-cho`.`20230214`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    //val (queue1, queue2) = intArrayOf(3, 2, 7, 2) to intArrayOf(4, 6, 5, 1)
    val (queue1, queue2) = intArrayOf(1, 2, 1, 2) to intArrayOf(1, 10, 1, 2)
    println(solution(queue1, queue2))
}

fun solution(queue1: IntArray, queue2: IntArray): Int {
    var (sum1, sum2) = queue1.sum() to queue2.sum()
    var answer = 0
    val dq1 = ArrayDeque<Int>().apply { this.addAll(queue1.toList()) }
    val dq2 = ArrayDeque<Int>().apply { this.addAll(queue2.toList()) }
    repeat(queue1.size * 2) {
        if (sum1 < sum2) {
            val target = dq2.removeFirst()
            dq1.addLast(target)
            sum2 -= target
            sum1 += target
        } else if (sum1 > sum2) {
            val target = dq1.removeFirst()
            dq2.addLast(target)
            sum1 -= target
            sum2 += target
        } else return answer
        answer++
    }
    return -1
}
