package `kyunghyun-cho`.`20230306`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val numbers = listOf(intArrayOf(9, 1, 5, 3, 6, 2), // -1, 5, 6, 6, -1, -1
        intArrayOf(2, 3, 3, 5), // 3, 5, 5, -1
        intArrayOf(3, 3, 3, 3), // -1 -1 -1 -1
        intArrayOf(1, 2, 3, 4), // 2, 3, 4, -1
        intArrayOf(4, 3, 2, 1), // -1 -1 -1 -1
        intArrayOf(1, 3, 1, 3, 1), // 3, -1, 3, -1, -1
        intArrayOf(1, 1, 1, 2), // 2, 2, 2, -1
        intArrayOf(3, 2, 4, 3, 5, 4, 6), // 4, 4, 5, 5, 6, 6, -1
        intArrayOf(3, 2, 4, 3, 5, 4), // 4, 4, 5, 5, -1, -1
        intArrayOf(5, 4, 3, 2, 3, 4, 5, 6) //6, 5, 4, 3, 4, 5, 6, -1
    )

    println(numbers.map { solution(it) }.joinToString("\n"))
}

fun solution(numbers: IntArray) = mutableListOf<Int>().apply {
    val biggerDeque = ArrayDeque<Int>()
    numbers.reversed().forEach { num ->
        while (biggerDeque.lastOrNull()?.let { it <= num } == true) biggerDeque.removeLast()
        this.add(biggerDeque.lastOrNull() ?: -1)
        biggerDeque.addLast(num)
    }
}.reversed()

