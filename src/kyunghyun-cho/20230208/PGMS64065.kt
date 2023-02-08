package `kyunghyun-cho`.`20230208`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val s = "{{4,2,3},{3},{2,3,4,1},{2,3}}" // 3241
    println(solution(s))
}

fun solution(s: String): List<Int> {
    val set = mutableSetOf<Int>()
    val tuples = "([0-9],*)+".toRegex().findAll(s).toList().map { it.value.split(",").map { it.toInt() }.toSet() }.sortedBy { it.size }
    tuples.forEach {
        set.add((it - set).first())
    }
    return set.toList()
}
