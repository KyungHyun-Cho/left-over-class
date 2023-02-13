package `dongyeon-lee`.`230208`

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        (s.indices).fold(s) { acc, index ->
            val rotated = acc.substring(index)
            if (rotated.checkIsCorrect()) answer++
            acc + acc[index]
        }
        return answer
    }

    fun String.checkIsCorrect(): Boolean {
        val deque = ArrayDeque<Char>()
        forEach {brace ->
            if (deque.lastOrNull()?.pair() == brace) deque.removeLast()
            else deque.add(brace)
        }
        return deque.isEmpty()
    }
    fun Char.pair() = when(this) {
        '[' -> ']' ; '(' -> ')' ; '{' -> '}' ; else -> ' '
    }
}