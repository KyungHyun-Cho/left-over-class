package `kyunghyun-cho`.`20230223`

/**
 * @author Kyunghyun Cho
 */

fun main(){
    val want = arrayOf("banana", "apple", "rice", "pork", "pot")
    val number = intArrayOf(3, 2, 2, 2, 1)
    val discount = arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")

    println(solution(want, number, discount))
}

fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
    val cntByWantItems = (want zip number.toList())
    return discount.toList().windowed(10)
        .map { discountTargets -> discountTargets.groupingBy { it }.eachCount() }
        .count { discountTargets ->
            cntByWantItems.all { (wantItem, wantCnt) -> discountTargets.getOrDefault(wantItem, 0) >= wantCnt }
        }
}
