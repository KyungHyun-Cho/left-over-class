package `kyunghyun-cho`.`20230223`

/**
 * @author Kyunghyun Cho
 */

fun main(){
    val want = arrayOf("banana", "apple", "rice", "pork", "pot")
    val number = intArrayOf(3, 2, 2, 2, 1)
    val discount = arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")

    println(solution(want, number, discount))
    println(fastSolution(want, number, discount))
}

fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
    val cntByWantItems = (want zip number.toList())
    return discount.toList().windowed(10)
        .map { discountTargets -> discountTargets.groupingBy { it }.eachCount() }
        .count { discountTargets ->
            cntByWantItems.all { (wantItem, wantCnt) -> discountTargets.getOrDefault(wantItem, 0) >= wantCnt }
        }
}

fun fastSolution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
    var answer = 0
    val cntByWantItems = (want zip number.toList())
    val discountMap = discount.take(9).groupingBy { it }.eachCount().toMutableMap()
    (9 until discount.size).forEach{ idx ->
        val target = discount[idx]
        discountMap[target] = discountMap.getOrDefault(target, 0) + 1
        if(cntByWantItems.all { (wantItem, wantCnt) -> discountMap.getOrDefault(wantItem, 0) >= wantCnt })
            answer++
        val deleteTarget = discount[idx - 9]
        discountMap[deleteTarget] = discountMap.getValue(deleteTarget) - 1
    }

    return answer
}
