package `kyunghyun-cho`.`20230213`.`simple`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val ss = listOf("[](){}", "}]()[{", "[)(]", "}}}")
    println(ss.map { solution(it) }) // 3 2 0 0
}

val OPEN_CHAR = setOf('(', '{', '[')
val CLOSE_CHAR = setOf(')', '}', ']')
val PAIR = mapOf(')' to '(', '}' to '{', ']' to '[')

fun solution(s: String): Int {
    val ss = s + s
    return s.indices.map { ss.substring(it, it + s.length) }.count { isRight(it) }
}

fun isRight(s: String): Boolean {
    if (s.first() in CLOSE_CHAR || s.last() in OPEN_CHAR) return false

    return ArrayDeque<Char>().apply {
        s.forEach { c ->
            if (c in OPEN_CHAR) this.addLast(c)
            else if (this.removeLastOrNull() != PAIR[c]) return false
        }
    }.isEmpty()
}
