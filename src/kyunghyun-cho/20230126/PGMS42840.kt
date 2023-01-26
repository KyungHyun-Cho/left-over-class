package `kyunghyun-cho`.`20230126`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    println(solution(intArrayOf(1, 3, 2, 4, 2, 1)))
}

fun solution(answers: IntArray): List<Int> {
    val rules = listOf(listOf(1, 2, 3, 4, 5),
        listOf(2, 1, 2, 3, 2, 4, 2, 5),
        listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))

    val answerCnt = rules.map { rule ->
        answers.withIndex().count { (idx, answer) -> answer == rule[idx % rule.size] }
    }

    val max = answerCnt.maxOrNull()
    return answerCnt.mapIndexed { idx, cnt -> (idx + 1).takeIf { cnt == max } }.filterNotNull()
}
