package `kyunghyun-cho`.`20230301`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    //val (brown, yellow) = 24 to 24
    val (brown, yellow) = 24 to 24
    println(solution(brown, yellow))
}

fun solution(brown: Int, yellow: Int) = (1..5000).asSequence().flatMap { f -> (1..5000).map { s -> f to s } }.filter { (f, s) -> f >= s }.filter { (f, s) -> f * s == brown + yellow }.first { (f, s) -> (f + s) * 2 - 4 == brown }.let { listOf(it.first, it.second) }

