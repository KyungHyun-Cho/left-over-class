package `jaeguk-cho`.`키패드 누르기`

import kotlin.math.abs

/**
 * @author Jaeguk Cho
 */

class `키패드 누르기` {
    fun solution(numbers: IntArray, hand: String): String {
        var left = Keypad.STAR
        var right = Keypad.HASH
        val moveLeft = { next: Keypad -> left = next; "L" }
        val moveRight = { next: Keypad -> right = next; "R" }

        return numbers.joinToString("") {
            val next = Keypad.getByKey(it)
            when {
                next.isLeft() -> moveLeft(next)
                next.isRight() -> moveRight(next)
                left dist next < right dist next -> moveLeft(next)
                left dist next > right dist next -> moveRight(next)
                hand == "left" -> moveLeft(next)
                else -> moveRight(next)
            }
        }
    }

    enum class Keypad(
        val key: Int,
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

    private infix fun Keypad.dist(key: Keypad): Int {
        return abs(location.first - key.location.first) + abs(location.second - key.location.second)
    }
}
