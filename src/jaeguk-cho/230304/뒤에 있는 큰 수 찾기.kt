package `jaeguk-cho`.`뒤에 있는 큰 수 찾기`

/**
 * @author Jaeguk Cho
 */

class `뒤에 있는 큰 수 찾기` {
    fun solution(numbers: IntArray) = with(ArrayDeque<Pair<Int, Int>>()) {
        val answer = MutableList(numbers.size) { -1 }
        add(Int.MAX_VALUE to -1)

        numbers.forEachIndexed { i, n ->
            while (last().first < n) {
                removeLast().also { answer[it.second] = n }
            }
            add(n to i)
        }

        answer
    }
}
