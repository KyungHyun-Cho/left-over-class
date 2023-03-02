package `kyunghyun-cho`.`20230302`

import java.util.*

/**
 * @author Kyunghyun Cho
 */

fun main() {
    //val topping = intArrayOf(1, 2, 1, 3, 1, 4, 1, 2) // 2
    //val topping = intArrayOf(1) // 0
    val topping = intArrayOf(1, 3, 1, 1, 1, 2) // 3

    println(solution(topping))
}

fun verySlowSolution(topping: IntArray): Int {
    return topping.indices.count { topping.take(it).toSet().size == topping.drop(it).toSet().size }
}

fun stillSlowSolution(topping: IntArray): Int {
    val one = ArrayDeque<Int>()
    val two = ArrayDeque<Int>().apply { this.addAll(topping.toList()) }
    var answer = 0
    while (two.isNotEmpty()) {
        one.addLast(two.pollFirst())
        if (one.toSet().size == two.toSet().size) answer++
    }
    return answer
}

fun solution(topping: IntArray): Int {
    val one = topping.toList().groupingBy { it }.eachCount().toMutableMap()
    val two = mutableSetOf<Int>()

    return topping.fold(0) { acc, i ->
        two.add(i)
        if (one[i] == 1) one.remove(i) else one[i] = one.getValue(i) - 1
        if (one.size == two.size) acc + 1 else acc
    }
}
