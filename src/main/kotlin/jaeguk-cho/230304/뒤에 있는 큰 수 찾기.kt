package `jaeguk-cho`.`230304`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(numbers: IntArray) = with(ArrayDeque<Pair<Int, Int>>()) {
        val answer = MutableList(numbers.size) { -1 }
        addLast(Int.MAX_VALUE to -1)

        numbers.forEachIndexed { i, n ->
            while (last().first < n) {
                removeLast().also { answer[it.second] = n }
            }
            addLast(n to i)
        }

        answer
    }
}
