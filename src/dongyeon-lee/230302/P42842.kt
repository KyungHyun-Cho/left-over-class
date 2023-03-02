package `dongyeon-lee`.`230302`

/* 롤케이크 자르기 */
class Solution {
    fun solution(topping: IntArray): Int {
        val chul = mutableSetOf<Int>()
        val bro = topping.toList().groupingBy { it }.eachCount().toMutableMap()
        return topping.fold(0) { acc, t ->
            chul.add(t)
            bro[t] = bro.getValue(t).minus(1)
            if (bro.getValue(t) < 1) bro.remove(t)
            if (chul.size == bro.size) acc.inc() else acc
        }
    }
}