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
    var lPos = 10
    var rPos = 12

    return numbers.joinToString("") { number ->
        when (number) {
            1, 4, 7 -> {lPos = number; "L"}
            3, 6, 9 -> {rPos = number; "R"}
            else -> {
                val lDist = lPos dist number
                val rDist = rPos dist number
                when{
                    lDist < rDist -> {lPos = number; "L"}
                    lDist == rDist && hand == "left" -> {lPos = number; "L"}
                    else -> {rPos = number; "R"}
                }
            }
        }
    }
}

infix fun Int.dist(other: Int) = getDist(this.toXY(), other.toXY())

fun Int.toXY() = if(this == 0) 3 to 1 else (this-1) / 3 to (this-1) % 3

fun getDist(srcXY: Pair<Int, Int>, destXY: Pair<Int, Int>) = abs(srcXY.first - destXY.first) + abs(srcXY.second - destXY.second)
