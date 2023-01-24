class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val dolls = List(board.size) { x -> ArrayDeque(board.map { it[x] }.filter { it > 0 }.reversed()) }
        val basket = ArrayDeque<Int>()
        return moves.map { move ->
            dolls[move.dec()].removeLastOrNull()?.let { doll ->
                if (basket.lastOrNull() == doll) {
                    basket.removeLast()
                    2
                } else basket.add(doll).let { 0 }
            } ?: 0
        }.sum()
    }
}