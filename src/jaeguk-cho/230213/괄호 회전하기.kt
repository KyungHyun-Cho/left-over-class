package `jaeguk-cho`.`괄호 회전하기`

/**
 * @author Jaeguk Cho
 */

class `괄호 회전하기` {
    fun solution(s: String) = s.indices.count { check(s.drop(it) + s.take(it)) }

    fun check(s: String) = with(ArrayDeque<Char>()) {
        s.forEach {
            if (lastOrNull().pair() == it) removeLast()
            else add(it)
        }
        isEmpty()
    }

    fun Char?.pair() = when (this) {
        '(' -> ')'
        '{' -> '}'
        '[' -> ']'
        else -> null
    }
}
