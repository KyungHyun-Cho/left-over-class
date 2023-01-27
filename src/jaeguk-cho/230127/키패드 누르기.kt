package `jaeguk-cho`.`키패드 누르기`

import kotlin.math.abs

/**
 * @author Jaeguk Cho
 */

class `키패드 누르기` {
    enum class Keypad(
        val key: Any,
        val location: Pair<Int, Int>,
    ) {
        ONE(1, 0 to 0),
        TWO(2, 0 to 1),
        THREE(3, 0 to 2),
        FOUR(4, 1 to 0),
        FIVE(5, 1 to 1),
        SIX(6, 1 to 2),
        SEVEN(7, 2 to 0),
        EIGHT(8, 2 to 1),
        NINE(9, 2 to 2),
        STAR(10, 3 to 0),
        ZERO(0, 3 to 1),
        HASH(11, 3 to 2),
        ;

        fun isLeft() = this in listOf(ONE, FOUR, SEVEN)
        fun isRight() = this in listOf(THREE, SIX, NINE)

        companion object {
            private val keyMap = values().associateBy { it.key }
            fun getByKey(key: Int) = keyMap[key] ?: throw Error()
        }
    }

    private fun distance(hand: Keypad, key: Keypad): Int {
        return abs(hand.location.first - key.location.first) + abs(hand.location.second - key.location.second)
    }

    fun solution(numbers: IntArray, hand: String): String {
        var left = Keypad.STAR
        var right = Keypad.HASH
        val answer = StringBuilder()
        val moveLeft = { next: Keypad ->
            left = next
            answer.append('L')
        }
        val moveRight = { next: Keypad ->
            right = next
            answer.append('R')
        }

        numbers.map { Keypad.getByKey(it) }.forEach { next ->
            when {
                next.isLeft() -> moveLeft(next)
                next.isRight() -> moveRight(next)
                distance(left, next) < distance(right, next) -> moveLeft(next)
                distance(left, next) > distance(right, next) -> moveRight(next)
                hand == "left" -> moveLeft(next)
                hand == "right" -> moveRight(next)
            }
        }

        return answer.toString()
    }
}
