package `jaeguk-cho`.`230209`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(fees: IntArray, records: Array<String>): List<Int> {
        return (0 until 10000).map { carNo ->
            records.filter { it.substringAfter(' ').substringBefore(' ').toInt() == carNo }
                .map { it.substringBefore(' ').toUnit() }
                .let { if (it.size % 2 == 1) it + 1439 else it }
                .let { it.chunked(2) { -it.reduce(Int::minus) }.sum() }
        }.filter { it > 0 }.map { calculate(fees, it) }
    }

    fun calculate(fees: IntArray, time: Int): Int {
        val (dt, df, ut, uf) = fees
        return df + ((time - dt + ut - 1) / ut * uf).coerceAtLeast(0)
    }

    fun String.toUnit(): Int {
        return split(':').map { it.toInt() }.let { (h, m) -> h * 60 + m }
    }
}
