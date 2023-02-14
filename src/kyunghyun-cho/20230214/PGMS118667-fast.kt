package `kyunghyun-cho`.`20230214`.`fast`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val (queue1, queue2) = intArrayOf(3, 2, 7, 2) to intArrayOf(4, 6, 5, 1)
    //val (queue1, queue2) = intArrayOf(1, 2, 1, 2) to intArrayOf(1, 10, 1, 2)
    println(solution(queue1, queue2))
}

fun solution(queue1: IntArray, queue2: IntArray): Int {
    var (sum1, sum2) = queue1.sum().toLong() to queue2.sum().toLong()
    var (pos1, pos2) = 0 to 0
    while (pos1 < queue1.size * 2 && pos2 < queue1.size * 2) {
        if (sum1 < sum2) {
            sum1 += if (pos2 < queue1.size) queue2[pos2] else queue1[pos2 % queue1.size]
            sum2 -= if (pos2 < queue1.size) queue2[pos2++] else queue1[pos2 % queue1.size].also { pos2++ }
        } else if (sum1 > sum2) {
            sum1 -= if (pos1 < queue1.size) queue1[pos1] else queue2[pos1 % queue1.size]
            sum2 += if (pos1 < queue1.size) queue1[pos1++] else queue2[pos1 % queue1.size].also { pos1++ }
        } else return pos1 + pos2
    }
    return -1
}
