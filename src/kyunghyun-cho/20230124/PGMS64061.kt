package `kyunghyun-cho`.`20230124`

/**
 * @author Kyunghyun Cho
 */

fun main() {

    val board = arrayOf(intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 3),
        intArrayOf(0, 2, 5, 0, 1),
        intArrayOf(4, 2, 4, 4, 2),
        intArrayOf(3, 5, 1, 3, 1))
    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    println(solution(board, moves))
}

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0
    val bucket = ArrayDeque<Int>()
    val stackBoard = List(board.size) { ArrayDeque<Int>() }.apply {
        board.forEach { row ->
            row.forEachIndexed { idx, item ->
                if (item != 0) this[idx].addFirst(item)
            }
        }
    }

    moves.forEach { idx ->
        stackBoard[idx - 1].removeLastOrNull()?.also {
            bucket.addLast(it)
            if (bucket.isPop()) {
                bucket.pop()
                answer++
            }
        }
    }

    return answer * 2
}

fun ArrayDeque<Int>.isPop(): Boolean {
    val size = this.size
    return if (size < 2) false
    else this[size - 1] == this[size - 2]
}

fun ArrayDeque<Int>.pop() = repeat(2) { this.removeLast() }
