package `dongyeon-lee`.`230223`

/* 카펫 */
class Solution {
    fun solution(brown: Int, yellow: Int): List<Int> {
        val area = brown + yellow
        return (3 .. area.div(2)).first { height ->
            val width = area / height
            val border = width * 2 + height * 2 - 4
            area % height == 0 && border == brown
        }.let { height ->
            listOf(area / height, height)
        }
    }
}