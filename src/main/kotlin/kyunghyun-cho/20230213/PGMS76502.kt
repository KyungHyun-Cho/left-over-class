package `kyunghyun-cho`.`20230213`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val ss = listOf("[](){}", "}]()[{", "[)(]", "}}}")
    println(ss.map { solution(it) }) // 3 2 0 0
}

val OPEN_CHAR = setOf('(', '{', '[')
val CLOSE_CHAR = setOf(')', '}', ']')
val pair = mapOf(')' to '(', '}' to '{', ']' to '[')

fun solution(s: String): Int {
    val dq = validationAndReturn(s) ?: return 0
    var answer = 0
    for (i in s.indices) {
        if (!fastValidation(dq)) {
            dq.addLast(dq.removeFirst())
            continue
        }
        if (isRight(dq)) answer++
        dq.addLast(dq.removeFirst())
    }
    return answer
}

fun validationAndReturn(s: String): ArrayDeque<Char>? {
    s.groupingBy { it }.eachCount().also {
        if (it['['] != it[']'] || it['('] != it[')'] || it['{'] != it['}']) return null
    }
    return ArrayDeque<Char>().apply { addAll(s.toList()) }
}

fun fastValidation(dq: ArrayDeque<Char>): Boolean {
    return (dq.firstOrNull() !in CLOSE_CHAR && dq.lastOrNull() !in OPEN_CHAR)
}

fun isRight(dq: ArrayDeque<Char>): Boolean {
    val save = ArrayDeque<Char>()
    dq.forEach { t ->
        if (t in OPEN_CHAR) {
            save.addLast(t)
        } else if (save.removeLastOrNull() != pair[t]) {
            return false
        }
    }
    return save.isEmpty()
}
