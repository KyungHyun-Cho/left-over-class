package `jaeguk-cho`.`주차 요금 계산`

/**
 * @author Jaeguk Cho
 */

class `주차 요금 계산` {
    fun solution(fees: IntArray, records: Array<String>): List<Int> {
        return (0..10000).map { num ->
            records.filter { it.substringAfter(' ').substringBefore(' ').toInt() == num }
                .map { it.substringBefore(' ').toUnit() }
                .let { if (it.size % 2 == 1) it + 1439 else it }
                .let { it.chunked(2) { -it.reduce(Int::minus) }.sum() }
        }.filter { it > 0 }.map { fees[1] + if (it <= fees[0]) 0 else (it - fees[0] + fees[2] - 1) / fees[2] * fees[3] }
    }

    fun String.toUnit(): Int {
        return split(':').map { it.toInt() }.let { (h, m) -> 60 * h + m }
    }
}
