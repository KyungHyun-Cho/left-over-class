package `kyunghyun-cho`.`20230208`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val s = "{{4,2,3},{3},{2,3,4,1},{2,3}}" // 3241
    println(solution(s))
}

fun solution(s: String): Set<Int> {
    val tuples = "([0-9],?)+".toRegex().findAll(s).toList().map { it.value.split(",").map { it.toInt() }.toSet() }.sortedBy { it.size }
    return tuples.reduce(Set<Int>::plus)
}
