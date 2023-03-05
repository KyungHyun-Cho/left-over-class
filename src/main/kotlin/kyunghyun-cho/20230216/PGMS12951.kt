package `kyunghyun-cho`.`20230216`

/**
 * @author Kyunghyun Cho
 */
fun main() {
    val s = "3people unFollowed me"
    println(solution(s))
}

fun solution(s: String) = s.lowercase().split(" ").joinToString(" ") { it.capitalize() }
