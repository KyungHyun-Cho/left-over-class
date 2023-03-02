package `jaeguk-cho`.`카펫`

/**
 * @author Jaeguk Cho
 */

class `카펫` {
    fun solution(brown: Int, yellow: Int) = with(brown + yellow) { (1..this).first { (this / it - 2) * (it - 2) == yellow }.let { listOf(this / it, it) } }
}
