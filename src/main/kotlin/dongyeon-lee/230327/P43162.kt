package `dongyeon-lee`.`230327`

/* 네트워크 */
class Solution {
    private lateinit var isVisited: MutableList<Boolean>
    fun solution(n: Int, computers: Array<IntArray>): Int {
        isVisited = MutableList(n) { false }
        val list = computers.mapIndexed { index, arr ->
            arr.mapIndexed { innerIndex, num ->
                if (num == 1) innerIndex else -1
            }.filter { it != -1 }.filter { it != index }
        }
        return (0 until n).fold(0) { acc, index ->
            acc + if (!isVisited[index]) { dfs(index, list) ; 1 } else 0
        }
    }
    fun dfs(curNode: Int, list: List<List<Int>>) {
        isVisited[curNode] = true // [ true , true, false ]

        list[curNode].forEach { nextNode ->
            if (!isVisited[nextNode]) {
                dfs(nextNode, list)
            }
        }
    }
}
fun main() {
    val s = Solution()
    s.solution(3, arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )).also { println(it) }
}