package `jaeguk-cho`.`기능개발`

/**
 * @author Jaeguk Cho
 */

class `기능개발` {
    fun solution(progresses: IntArray, speeds: IntArray): List<Int> {
        val answer = mutableListOf<Int>()
        val stack = ArrayDeque<Int>()
        val list = speeds.mapIndexed { i, n -> ((100 - progresses[i]) + n - 1) / n } + 105

        list.forEach {
            if (stack.isNotEmpty() && stack.first() < it) {
                answer += stack.size
                while (stack.isNotEmpty()) stack.removeLast()
            }
            stack.add(it)
        }

        return answer
    }
}
