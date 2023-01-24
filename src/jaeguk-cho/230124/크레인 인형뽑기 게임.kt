import java.util.*
import kotlin.collections.ArrayDeque

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val (r, c) = board.size to board.first().size
        val rotatedBoard = List(c) { x -> List(r) { y -> board[y][x] } }
        val map = List(c) { ArrayDeque(rotatedBoard[it].filter { it > 0 }) }
        val basket = Stack<Int>()
        var ans = 0

        moves.forEach { move ->
            map[move - 1].removeFirstOrNull()?.also {
                if (basket.isNotEmpty() && basket.peek() == it) {
                    basket.pop()
                    ans += 2
                } else {
                    basket.push(it)
                }

            }
        }

        return ans
    }
}
