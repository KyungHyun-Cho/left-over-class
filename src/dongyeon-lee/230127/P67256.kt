package `dongyeon-lee`.`230127`

import kotlin.math.abs

const val STAR = 10 ; const val HASH = 11 // *, #
const val RIGHT_HAND = "right" ; const val LEFT_HAND = "left"
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val phone = listOf(
            (4 to 2),
            (1 to 1), (1 to 2), (1 to 3),
            (2 to 1), (2 to 2), (2 to 3),
            (3 to 1), (3 to 2), (3 to 3),
            (4 to 1),           (4 to 3)
        )
        var hands = (phone[STAR] to phone[HASH])
        return numbers.map { num ->
            val numLoc = phone[num]
            val leftDst = abs(hands.first.first - numLoc.first) + abs(hands.first.second - numLoc.second)
            val rightDst = abs(hands.second.first - numLoc.first) + abs(hands.second.second - numLoc.second)
            when {
                num in listOf(3,6,9) -> "R"
                num in listOf(1,4,7) -> "L"
                leftDst < rightDst -> "L"
                leftDst > rightDst -> "R"
                hand == RIGHT_HAND -> "R"
                else -> "L"
            }.apply {
                if (this == "R") hands = hands.copy(second = numLoc)
                else  hands = hands.copy(first = numLoc)
            }
        }.joinToString("")
    }
}