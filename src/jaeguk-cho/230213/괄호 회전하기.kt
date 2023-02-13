package `jaeguk-cho`.`괄호 회전하기`


import java.util.*

/**
 * @author Jaeguk Cho
 */

class `괄호 회전하기` {
    fun solution(s: String) = s.indices.count { check(s.drop(it) + s.take(it)) }

    fun check(s: String): Boolean {
        val stack = Stack<Char>()

        s.forEach {
            when (it) {
                '(', '{', '[' -> stack.push(it)
                else -> if (stack.isNotEmpty() && stack.peek() == it.pair()) {
                    stack.pop()
                } else {
                    stack.push(it)
                }
            }
        }

        return stack.isEmpty()
    }

    fun Char.pair() = when (this) {
        '(' -> ')'
        '{' -> '}'
        '[' -> ']'
        ')' -> '('
        '}' -> '{'
        ']' -> '['
        else -> throw Exception()
    }
}
