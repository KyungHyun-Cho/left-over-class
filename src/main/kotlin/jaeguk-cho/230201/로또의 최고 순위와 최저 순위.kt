package `jaeguk-cho`.`로또의 최고 순위와 최저 순위`

/**
 * @author Jaeguk Cho
 */

class `로또의 최고 순위와 최저 순위` {
    fun solution(lottos: IntArray, win_nums: IntArray): List<Int> {
        val min = 7 - lottos.count { it in win_nums }
        val max = min - lottos.count { it == 0 }

        return listOf(max, min).map { it.coerceAtMost(6) }
    }
}
