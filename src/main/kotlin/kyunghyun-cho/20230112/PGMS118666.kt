package `20230112`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val survey = arrayOf("AN", "CF", "MJ", "RT", "NA")
    val choice = intArrayOf(5, 3, 2, 7, 5)
    println(solution(survey, choice))
}

fun solution(survey: Array<String>, choices: IntArray): String {
    val scoreByType = mutableMapOf('R' to 0, 'T' to 0, 'C' to 0, 'F' to 0, 'J' to 0, 'M' to 0, 'A' to 0, 'N' to 0)
    val pair = arrayOf(Pair('R', 'T'), Pair('C', 'F'), Pair('J', 'M'), Pair('A', 'N'))
    (survey.indices).forEach { questionNo ->
        val choice = choices[questionNo]
        when (choice) {
            1, 2, 3 -> survey[questionNo][0] to 4 - choice
            5, 6, 7 -> survey[questionNo][1] to choice - 4
            else -> null
        }?.let { (type, score) -> scoreByType[type] = scoreByType[type]!! + score }
    }

    return pair.map { (f, s) ->
        f.takeIf { scoreByType.getValue(f) >= scoreByType.getValue(s) } ?: s
    }.joinToString("")
}
