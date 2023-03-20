package `dongyeon-lee`.`230320`

/* 메뉴 리뉴얼 */
class Solution {
    var max = mutableListOf<String>()
    var maxSize = 0

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: MutableList<String> = arrayOf<String>().toMutableList()
        val sortedOrder = orders.map { it.toCharArray().sorted().joinToString("") }
        course.forEach {
            max.clear() ; maxSize = 0
            dfs(0, it, sortedOrder, "")
            max.map { it.toCharArray().sorted().joinToString("") }.toSet().forEach { answer.add(it) }
        }

        return answer.sorted().toTypedArray()
    }

    private fun dfs(depth: Int, course: Int, orders: List<String>, comb: String) {
        if (depth == course) {
            val size = orders.count { order ->
                val new = order.toList() - comb.toList()
                new.size + comb.length== order.length
            }

            if (size < 2) return
            if (size < maxSize) return
            if (size > maxSize) {
                maxSize = size
                max.apply { clear() ; add(comb) }
            } else if (size == maxSize) {
                max.add(comb)
            }
            return
        }

        for (i in 0 until 26) {
            val alphabet = ('A' + i)
            if (alphabet in comb) continue
            dfs(depth + 1, course, orders, comb + alphabet)
        }
    }
}