package `kyunghyun-cho`.`20230127`

import java.lang.Math.abs

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val numbers = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
    println(solution(numbers, "right"))
}

fun solution(numbers: IntArray, hand: String): String {
    var lPos = 10 // 왼손 초기값 * (키패드에서 10번째 순서)
    var rPos = 12 // 오른손 초기값 # (키패드에서 12번째 순서)

    val setLPosAndReturn = { number: Int -> lPos = number; "L" }
    val setRPosAndReturn = { number: Int -> rPos = number; "L" }

    return numbers.joinToString("") { number ->
        when (number) {
            1, 4, 7 -> setLPosAndReturn(number)
            3, 6, 9 -> setRPosAndReturn(number)
            else -> {
                val lDist = lPos dist number
                val rDist = rPos dist number
                when {
                    lDist < rDist -> setLPosAndReturn(number)
                    rDist < lDist -> setRPosAndReturn(number)
                    else -> if (hand == "left") setLPosAndReturn(number) else setRPosAndReturn(number)
                }
            }
        }
    }
}

infix fun Int.dist(other: Int) = getDist(this.toXY(), other.toXY())

fun Int.toXY() = (if (this == 0) 10 else this - 1).let { it / 3 to it % 3 }

fun getDist(srcXY: Pair<Int, Int>, destXY: Pair<Int, Int>) =
    abs(srcXY.first - destXY.first) + abs(srcXY.second - destXY.second)
