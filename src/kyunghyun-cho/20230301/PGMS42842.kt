package `kyunghyun-cho`.`20230301`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val (brown, yellow) = 24 to 24
    println(solution(brown, yellow))
    println(fastSolution(brown, yellow))
    println(prettyFastSolution(brown, yellow))
    println(superFastSolution(brown, yellow))
    println(superFastPrettySolution(brown, yellow))
}

fun solution(brown: Int, yellow: Int) =
    (1..5000).asSequence().flatMap { f -> (1..f).map { s -> f to s } }
        .first { (f, s) -> (f * s == brown + yellow) && ((f + s) * 2 - 4 == brown) }
        .toList()

fun fastSolution(brown: Int, yellow: Int): List<Int> {
    (kotlin.math.ceil(kotlin.math.sqrt((brown.toDouble() + yellow))).toInt()..5000).forEach { w ->
        for (h in w downTo 1) {
            if (w * h < brown + yellow) break
            if ((w * h == brown + yellow) && ((w + h) * 2 - 4 == brown)) return listOf(w, h)
        }
    }
    return emptyList()
}

fun prettyFastSolution(brown: Int, yellow: Int): List<Int> {
    return (1..5000).first { w ->
        (w downTo (brown + yellow) / w).any { h -> (w * h == brown + yellow) && ((w + h) * 2 - 4 == brown) }
    }.let { listOf(it, (brown + yellow) / it) }
}

fun superFastSolution(brown: Int, yellow: Int): List<Int> {
    return (1..(brown+yellow)).first { w ->
        if ((brown + yellow) % w != 0) return@first false
        val h = (brown + yellow) / w
        if (w < h) return@first false
        (w + h) * 2 - 4 == brown
    }.let { listOf(it, (brown + yellow) / it) }
}

fun superFastPrettySolution(brown: Int, yellow: Int): List<Int> {
    return (1..(brown+yellow))
        .filter { (brown + yellow) % it == 0 }
        .first { h ->
            val w = (brown + yellow) / h
            (w + h) * 2 - 4 == brown
        }.let { listOf((brown + yellow) / it, it) }
}
