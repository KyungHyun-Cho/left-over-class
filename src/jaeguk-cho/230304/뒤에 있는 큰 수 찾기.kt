package `jaeguk-cho`.`뒤에 있는 큰 수 찾기`

/**
 * @author Jaeguk Cho
 */

class `뒤에 있는 큰 수 찾기` {
    fun solution(numbers: IntArray): List<Int> {
        val answer = MutableList(numbers.size) { -1 }
        val stack = ArrayDeque<Pair<Int, Int>>().also { it.add(Int.MAX_VALUE to -1) }

        numbers.forEachIndexed { i, n ->
            while (stack.last().first < n) {
                stack.removeLast().also {
                    answer[it.second] = n
                }
            }
            stack.add(n to i)
        }

        return answer
    }
}
