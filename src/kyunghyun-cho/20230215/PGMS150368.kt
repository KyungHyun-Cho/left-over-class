package `kyunghyun-cho`.`20230215`

import kotlin.math.ceil
import kotlin.math.pow

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val users = arrayOf(intArrayOf(40, 2900),
        intArrayOf(23, 10000),
        intArrayOf(11, 5200),
        intArrayOf(5, 5900),
        intArrayOf(40, 3100),
        intArrayOf(27, 9200),
        intArrayOf(32, 6900))
    val emoticons = intArrayOf(1300, 1500, 1600, 4900)
//    val users = arrayOf(intArrayOf(40, 10000), intArrayOf(25, 10000))
//    val emoticons = intArrayOf(7000, 9000)

    println(solution(users, emoticons).toList())
}

fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
    val answer = intArrayOf(0, 0)
    val discountPool = users.map { (ceil(it[0] / 10.0) * 10).toInt() }
    combinationsWithRepetition(discountPool, emoticons.size).forEach { discountRates ->
        users.map { (buyRate, subscribePrice) ->
            subscribePrice to
            discountRates.withIndex()
                .filter { (_, discountRate) -> discountRate >= buyRate }
                .sumOf { (idx, discountRate) -> emoticons[idx] * (100-discountRate) / 100 }
        }.partition { (subscribePrice, paid) -> paid >= subscribePrice }
            .also { (subscribe, notSubscribe) ->
                val subscriberCnt = subscribe.size
                val notSubscribePaidSum = notSubscribe.sumOf { it.second }
                if(subscriberCnt > answer[0] || (subscriberCnt >= answer[0] && notSubscribePaidSum >= answer[1])) {
                    answer[0] = subscriberCnt
                    answer[1] = notSubscribePaidSum
                }
            }
    }

    return answer
}

fun combinationsWithRepetition(list: List<Int>, n: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val k = list.distinct().size
    for (i in 0 until  k.toDouble().pow(n).toInt()) {
        val indices = i.toString(k).padStart(n, '0').map { it.toString().toInt() }
        val combination = indices.map { list[it] }
        result.add(combination)
    }
    return result
}
