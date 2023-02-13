package `jaeguk-cho`.`괄호 회전하기`


import java.util.*

/**
 * @author Jaeguk Cho
 */

class `괄호 회전하기` {
    fun solution(s: String) = s.indices.count { check(s.drop(it) + s.take(it)) }

    fun check(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        s.forEach {
            if (stack.lastOrNull().pair() == it) stack.removeLast()
            else stack.add(it)
        }

        return stack.isEmpty()
    }

    fun Char?.pair() = when (this) {
        '(' -> ')'
        '{' -> '}'
        '[' -> ']'
        else -> null
    }
}
