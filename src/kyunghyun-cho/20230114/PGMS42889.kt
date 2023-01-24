package `20230114`

/**
 * @author Kyunghyun Cho
 */
fun main(){
    val n = 5
    val stages = intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
    println(solution(n, stages))
}

fun solution(N: Int, stages: IntArray): List<Int> {
    var challengerCnt = stages.size
    val keepCntByStage = (1..N).associateWith { stage -> stages.count { it == stage } }

    return keepCntByStage.entries.map { (stage, peopleCnt) ->
        val failRate = (0.0).takeIf { challengerCnt == 0 } ?: (peopleCnt / challengerCnt.toDouble())
        challengerCnt -= peopleCnt
        stage to failRate
    }.sortedWith ( compareByDescending<Pair<Int, Double>> { it.second }.thenBy { it.first })
        .map { it.first }
}
