package `dongyeon-lee`.`230322`

import java.util.PriorityQueue

/* 배다루 */
class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val nodes = MutableList(N + 1) { mutableListOf<Node>() }

        road.forEach { (from, to, weight) ->
            nodes[from].add(Node(to, weight))
            nodes[to].add(Node(from, weight)) // 양방향
        }
        return dijkstra(N, nodes).count { it <= k }
    }

    fun dijkstra(n: Int, nodes: List<List<Node>>): List<Int> {
        val dst = MutableList(n  + 1) { 1_000_000_000 }
        val pq = PriorityQueue<Node>()
        dst[1] = 0
        pq.add(Node(1, 0))
        while (pq.isNotEmpty()) {
            val node = pq.poll()
            if (dst[node.to] < node.weight) continue

            nodes[node.to].forEach { childNode ->
                if (dst[childNode.to] > node.weight + childNode.weight) {
                    dst[childNode.to] = node.weight + childNode.weight
                    pq.add(Node(childNode.to, dst[childNode.to]))
                }
            }
        }
        return dst
    }
}
data class Node(val to: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int = weight - other.weight
}

fun main() {
    val s = Solution()
    s.solution(5, arrayOf(
        intArrayOf(1, 2, 1),
        intArrayOf(2, 3, 3),
        intArrayOf(5, 2, 2),
        intArrayOf(1, 4, 2),
        intArrayOf(5, 3, 1),
        intArrayOf(5, 5, 2),
    ), 3).also { println(it) }

    s.solution(6, arrayOf(
        intArrayOf(1, 2, 1),
        intArrayOf(1, 3, 2),
        intArrayOf(2, 3, 2),
        intArrayOf(3, 4, 3),
        intArrayOf(3, 5, 2),
        intArrayOf(3, 5, 3),
        intArrayOf(5, 6, 1)
    ), 4).also { println(it) }
}