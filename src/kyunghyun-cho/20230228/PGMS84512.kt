package `kyunghyun-cho`.`20230228`

import kotlin.math.pow

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val word = "I"
    println(solution(word))
}

var global = 0
val list = listOf('A', 'E', 'I', 'O', 'U')

fun solution(word: String): Int {
    try {
        rec(word, mutableListOf())
    } finally {
        return global
    }
}

fun rec(find: String, picked: MutableList<Char>) {
    if (picked.joinToString("") == find) {
        throw Exception()
    } else {
        list.forEachIndexed { idx, ch ->
            if (picked.size == 5) {
                picked.removeLast()
                return
            }
            picked.add(ch)
            global++
            rec(find, picked)
        }
        picked.removeLast()
    }
}
