package `kyunghyun-cho`.`230209`

import kotlin.math.ceil

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val fees = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf("05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT")
    println(solution(fees, records))
}

fun solution(fees: IntArray, records: Array<String>) =
    records.map { it.split(" ") }
        .groupBy({ it[1] }, { it[0].toIntTime() })
        .mapValues { (_, value) -> value.takeIf { it.size % 2 == 0 } ?: (value + (1440 - 1)) }
        .mapValues { (_, value) -> value.windowed(2, 2)
            .sumOf { (in1, out) -> out - in1 }
            .let { calc(fees, it) }
        }.toSortedMap().values

fun calc(fees: IntArray, time: Int): Int {
    val (defaultTime, defaultFee, unitTime, unitFee) = fees
    return defaultFee + (ceil((time - defaultTime) / unitTime.toDouble()) * unitFee).toInt().coerceAtLeast(0)
}

fun String.toIntTime() = this.split(":").map(String::toInt).let { (h, m) -> h * 60 + m }
