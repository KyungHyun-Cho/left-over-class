package `jaeguk-cho`.`기능개발`

/**
 * @author Jaeguk Cho
 */

class `기능개발` {
    fun solution(progresses: IntArray, speeds: IntArray): List<Int> {
        val answer = mutableListOf<Int>()
        val stack = ArrayDeque<Int>()

        progresses.zip(speeds) { p, s -> (100 - p + s - 1) / s }.forEach {
            if (stack.isNotEmpty() && stack.first() < it) {
                answer += stack.size
                stack.clear()
            }
            stack.add(it)
        }

        return answer + stack.size
    }
}
