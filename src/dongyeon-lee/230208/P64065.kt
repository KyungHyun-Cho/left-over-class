package `dongyeon-lee`.`230208`

class Solution {
    fun solution(s: String): IntArray {
        var prevList = listOf<Int>()
        return s.substring(1, s.length - 1).split("},{").map {
            it.replace("{", "").replace("}", "").split(",").map { it.toInt() }
        }.sortedBy { it.size }.map {
            val remainder = if (prevList.isEmpty()) { it.first() } else { (it - prevList).first() }
            prevList = it
            remainder
        }.toIntArray()
    }

    fun solution2(s: String) = s.split("},{").map {
        it.replace("{", "").replace("}", "").split(",").map { it.toInt() }
    }.sortedBy { it.size }.fold(setOf<Int>()) { acc, ints -> acc.union(ints) }
}