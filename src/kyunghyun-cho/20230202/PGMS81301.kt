package `kyunghyun-cho`.`20230202`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    // val s = "one4seveneight" // 1478
     val s = "2three45sixseven" // 234567
    // val s = "threetwooneone" // 3211
    println(solution(s))
    println(solutionRegex(s))
}

fun solution(s: String): Int {
    var answer = s
    listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine").forEachIndexed { idx, eng ->
        answer = answer.replace(eng.toRegex(), idx.toString())
    }
    return answer.toInt()
}

fun solutionRegex(s: String): Int {
    val numByEng = mapOf("zero" to "0", "one" to "1", "two" to "2", "three" to "3", "four" to "4", "five" to "5", "six" to "6", "seven" to "7", "eight" to "8", "nine" to "9", "\\d" to "AnyNumber")
    return numByEng.keys.joinToString("|").toRegex().findAll(s).joinToString("") { numByEng[it.value] ?: it.value }.toInt()
}
