package `20230110`

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * @author Kyunghyun Cho
 */

fun solution(today: String, terms: Array<String>, privacies: Array<String>): List<Int> {
    val answer = mutableListOf<Int>()
    val todayYmd = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
    val expireMonthByTerm = terms.associate { it.split(" ").let { (k, v) -> k to v.toLong() } }
    privacies.forEachIndexed { idx, privacy ->
        privacy.split(" ").let { (targetDate, term) ->
            val formattedDate = LocalDate.parse(targetDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
            val expireDate = formattedDate.plusMonths(expireMonthByTerm.getValue(term))
            !expireDate.isAfter(todayYmd)
        }.isTrueThen { answer.add(idx + 1) }
    }

    return answer
}

fun Boolean.isTrueThen(block: () -> Any) {
    if (this) {
        block()
    }
}
