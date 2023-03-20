package `dongyeon-lee`.`230320`

/* 메뉴 리뉴얼 */
class Solution {
    var max = mutableListOf<String>()
    var maxSize = 0

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: MutableList<String> = arrayOf<String>().toMutableList()
        val sortedOrder = orders.map { it.toCharArray().sorted().joinToString("") }
        val menus = orders.flatMap { it.toCharArray().sorted() }.toSet()
        course.forEach {
            max.clear() ; maxSize = 0
            dfs(0, it, sortedOrder, "", menus)
            max.map { it.toCharArray().sorted().joinToString("") }.toSet().forEach { answer.add(it) }
        }

        return answer.sorted().toTypedArray()
    }

    private fun dfs(depth: Int, course: Int, orders: List<String>, comb: String, menus: Set<Char>) {
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

        for (menu in menus) {
            if (menu in comb) continue
            dfs(depth + 1, course, orders, comb + menu, menus)
        }
    }
}