package `20220117`

/**
 * @author Kyunghyun Cho
 */

fun solution(numbers: IntArray) = numbers.toList().groupingBy { it }.eachCount().let { map -> (map.filter { it.value > 1 }.keys.map { it * 2 } + map.keys.let{ aa -> aa.flatMap { o -> aa.map { t -> o to t } }.filter { it.first != it.second }.map { it.first + it.second }}).distinct().sorted() }
