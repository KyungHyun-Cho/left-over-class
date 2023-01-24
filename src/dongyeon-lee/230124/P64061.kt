import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val dolls = List<Queue<Int>>(board.first().size) { LinkedList() }
        val basket = Stack<Int>()
        board.forEach {
            it.forEachIndexed { index, i ->
                if (i != 0) {
                    dolls[index].offer(i)
                }
            }
        }

        return moves.map {
            val doll = dolls[it - 1].pollOrNull()
            doll?.let {
                if (basket.isNotEmpty() && basket.peek() == it) {
                    basket.pop()
                    2
                } else basket.push(doll).let { 0 }
            } ?: 0
        }.sum()
    }
    fun <T>Queue<T>.pollOrNull() = if (this.isNotEmpty()) this.poll() else null
}