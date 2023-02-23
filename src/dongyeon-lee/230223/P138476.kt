package `dongyeon-lee`.`230223`

/* 할인 행사 */
class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>) =
        discount.toList().windowed(10).count { window ->
            val count = window.groupBy { it }.entries.associate { it.key to it.value.count() }
            want.filterIndexed { index, s -> count[s] == number[index] }.size == want.size
        }
}