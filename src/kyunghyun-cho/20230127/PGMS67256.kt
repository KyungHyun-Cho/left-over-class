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
    val handType = HAND.valueOf(hand.uppercase())
    var lPos = 10
    var rPos = 12

    return numbers.joinToString("") { number ->
        when (number) {
            1, 4, 7 -> {lPos = number; "L"}
            3, 6, 9 -> {rPos = number; "R"}
            else -> {
                val lDist = getDist(lPos.toXY(), number.toXY())
                val rDist = getDist(rPos.toXY(), number.toXY())
                if(lDist < rDist){
                    lPos = number
                    "L"
                }else if(lDist == rDist && handType == HAND.LEFT){
                    lPos = number
                    "L"
                }else if(lDist == rDist && handType == HAND.RIGHT){
                    rPos = number
                    "R"
                }else{
                    rPos = number
                    "R"
                }
            }
        }
    }
}

fun Int.toXY(): Pair<Int, Int>{
    return if(this == 0) 3 to 1 else (this-1) / 3 to (this-1) % 3
}

fun getDist(srcXY: Pair<Int, Int>, destXY: Pair<Int, Int>) = abs(srcXY.first - destXY.first) + abs(srcXY.second - destXY.second)


enum class HAND {
    LEFT, RIGHT
}
