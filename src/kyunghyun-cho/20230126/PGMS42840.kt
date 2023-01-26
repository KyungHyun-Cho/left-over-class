package `kyunghyun-cho`.`20230126`

/**
 * @author Kyunghyun Cho
 */

fun main(){
    println(solution(intArrayOf(1,3,2,4,2,1)))
}

fun solution(answers: IntArray): List<Int> {
    val one = listOf(1,2,3,4,5)
    val two = listOf(2,1,2,3,2,4,2,5)
    val three = listOf(3,3,1,1,2,2,4,4,5,5)

    val answerCnt = intArrayOf(0,0,0)
    answers.forEachIndexed { idx, answer ->
        if(one[idx % one.size] == answer) answerCnt[0]++
        if(two[idx % two.size] == answer) answerCnt[1]++
        if(three[idx % three.size] == answer) answerCnt[2]++
    }
    val max = answerCnt.maxOrNull()
    return answerCnt.mapIndexed { index, i -> (index+1).takeIf { i == max } }.filterNotNull()
}
