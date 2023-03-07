package `20230119`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
    val k = 2
    println(solution(id_list, report, k))
}

fun solution(id_list: Array<String>, report: Array<String>, k: Int): List<Int> {
    val uniqueReportMap = report.toSet().map { it.split(" ") }.groupBy({ it[0] }, { it[1] })
    val bannedIdSet = uniqueReportMap.flatMap { it.value }.groupingBy { it }.eachCount().filter { it.value >= k }.keys
    return id_list.map { uniqueReportMap[it]?.count { reportTarget -> bannedIdSet.contains(reportTarget) } ?: 0 }
}


