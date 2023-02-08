package `jaeguk-cho`.`튜플`

/**
 * @author Jaeguk Cho
 */

class '튜플' {
    fun solution(s: String): List<Int> {
        val data = s.drop(2).dropLast(2).split("},{").map { it.split(',').map { it.toInt() } } + listOf(listOf())
        return data.sortedBy { -it.size }.zipWithNext(List<Int>::minus).flatten().reversed()
    }
}
