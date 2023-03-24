package `kyunghyun-cho`.`20230324`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    listOf(
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc") to arrayOf("fr*d*", "abc1**"),
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc") to arrayOf("*rodo", "*rodo", "******"),
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc") to arrayOf("fr*d*", "*rodo", "******", "******"),
        arrayOf("abc", "ccd", "abcde", "aabcc", "aba") to arrayOf("***", "***", "*****"),
        arrayOf("abc", "ccd", "abd") to arrayOf("***", "***", "***"),
        arrayOf("a") to arrayOf("*"),
        arrayOf("a", "z") to arrayOf("*"),
        arrayOf("123", "124", "125", "126", "127", "128", "129", "120") to arrayOf("***", "***", "***")
    ).map { solution(it.first, it.second) }.also { println(it) } // 2, 2, 3, 6, 1, 1, 2, 56
}

fun solution(userIds: Array<String>, bannedIds: Array<String>) = bannedIds.map { makeAvailableComb(userIds, it) }.let { find(it) }

fun find(param: List<List<String>>, depth: Int = 0, picked: MutableSet<String> = mutableSetOf(), answer: MutableSet<Set<String>> = mutableSetOf(), ): Int {
    if (depth == param.size) { answer.add(picked.toSet()) }
    else {
        param[depth].forEach {
            if (picked.add(it)) {
                find(param, depth + 1, picked, answer)
                picked.remove(it)
            }
        }
    }
    return answer.size
}

fun makeAvailableComb(userIds: Array<String>, bannedId: String) = userIds.filter { "^${bannedId.replace("*", ".")}$".toRegex().matches(it) }
