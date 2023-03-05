package `20230118`

/**
 * @author Kyunghyun Cho
 */
fun solution(id_list: Array<String>, report: Array<String>, k: Int): List<Int> {
    val bannedIds = report.toSet()
        .let { uniqueReport -> id_list.filter { id -> uniqueReport.count { it.substringAfter(' ') == id } >= k } }
    return report.toSet().let { uniqueReport ->
        id_list.map { id ->
            uniqueReport.filter {
                val (from, to) = it.split(' ')
                from == id && to in bannedIds
            }.size
        }
    }
}
