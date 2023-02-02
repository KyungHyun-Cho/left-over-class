package `jaeguk-cho`.`숫자 문자열과 영단어`

/**
 * @author Jaeguk Cho
 */

class `숫자 문자열과 영단어` {
    val dictionary = listOf(
        "zero" to "0",
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9",
    )

    fun solution(s: String): Int {
        var t = s

        dictionary.forEach { (english, number) ->
            t = t.replace(english, number)
        }

        return t.toInt()
    }
}
