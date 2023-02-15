package `dongyeon-lee`.`230213`

class Solution {
    fun solution(s: String) = s.indices.count { (s.drop(it) + s.take(it)).checkIsCorrect() }

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