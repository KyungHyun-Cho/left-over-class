package `dongyeon-lee`.`230223`

* 롤케이크 자르기 */
class Solution {
    fun solution(topping: IntArray): Int {
        val chul = mutableSetOf<Int>()
        val bro = topping.groupBy { it }.map { it.key to it.value.size }.toMap().toMutableMap()
        return topping.fold(0) { acc, t ->
            chul.add(t)
            if (bro.contains(t)) {
                bro[t] = bro.getValue(t).minus(1)
                if (bro.getValue(t) < 1) bro.remove(t)
            }
            if (chul.size == bro.size) acc.inc() else acc
        }
    }
}