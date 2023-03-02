package `jaeguk-cho`.`롤케이크 자르기`

/**
 * @author Jaeguk Cho
 */

class `롤케이크 자르기` {
    fun solution(topping: IntArray): Int {
        val list1 = mutableSetOf<Int>()
        val list2 = mutableSetOf<Int>()

        val left = topping.runningFold(0) { acc, i -> if (i !in list1) acc + 1.also { list1 += i } else acc }
        val right =
            topping.reversed().runningFold(0) { acc, i -> if (i !in list2) acc + 1.also { list2 += i } else acc }
                .reversed()

        return left.zip(right, Int::minus).count { it == 0 }
    }
}
