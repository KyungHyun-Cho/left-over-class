package `jaeguk-cho`.`230208`

/**
 * @author Jaeguk Cho
 */

class Solution {
    fun solution(s: String) = s.drop(2).dropLast(2).split("},{").map { it.split(',') }.sortedBy { it.size }.fold(setOf(), Set<String>::union).map(String::toInt)
}
