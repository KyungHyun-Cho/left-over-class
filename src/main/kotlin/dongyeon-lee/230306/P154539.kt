package `dongyeon-lee`.`230306`

/* 뒤에있는 큰 수 찾기 */
class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = numbers.toMutableList()
        val stack = ArrayDeque<Int>()
        repeat(numbers.size) { idx ->
            while (stack.isNotEmpty() && answer[stack.last()] < answer[idx]) {
                answer[stack.removeLast()] = answer[idx]
            }
            stack.addLast(idx)
        }
        while (stack.isNotEmpty()) {
            answer[stack.removeLast()] = -1
        }
        return answer.toIntArray()
    }
}