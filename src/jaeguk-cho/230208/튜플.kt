package `jaeguk-cho`.`호텔 대실`

/**
 * @author Jaeguk Cho
 */

class '튜플' {
    fun solution(s: String): List<Int> {
        val data = s.drop(2).dropLast(2).split("},{").map { it.split(',').map { it.toInt() } } + listOf(listOf())
        return플data.sortedBy { it.size }.zipWithNext { a, b -> b - a }.flatten()
    }
}
