package `kyunghyun-cho`.`20230301`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val (brown, yellow) = 24 to 24
    println(solution(brown, yellow))
    println(fastSolution(brown, yellow))
}

fun solution(brown: Int, yellow: Int) =
    (1..5000).asSequence().flatMap { f -> (1..f).map { s -> f to s } }
        .first { (f, s) -> (f * s == brown + yellow) && ((f + s) * 2 - 4 == brown) }
        .toList()

fun fastSolution(brown: Int, yellow: Int): List<Int>{
    (1..5000).forEach { w ->
        (1..w).forEach { h ->
            if((w * h == brown + yellow) && ((w + h) * 2 - 4 == brown)) return listOf(w, h)
        }
    }
    return emptyList()
}

