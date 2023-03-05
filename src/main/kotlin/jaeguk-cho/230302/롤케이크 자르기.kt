package `jaeguk-cho`.`230302`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(topping: IntArray): Int {
        val list1 = mutableSetOf<Int>()
        val list2 = mutableSetOf<Int>()

        val left = topping.map { list1 += it; list1.size }.reversed().drop(1)
        val right = topping.reversed().map { list2 += it; list2.size }.dropLast(1)

        return left.zip(right, Int::equals).count { it }
    }
}
