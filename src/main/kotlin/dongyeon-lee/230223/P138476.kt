package `dongyeon-lee`.`230223`

/* 할인 행사 */
class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>) =
        discount.toList().windowed(10).count { window ->
            val count = window.groupingBy { it }.eachCount()
            want.withIndex().count { (idx, value) -> count.getValue(value) >= number[idx] } == want.size
        }
}