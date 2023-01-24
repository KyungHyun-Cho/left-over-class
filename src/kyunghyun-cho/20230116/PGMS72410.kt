package `20230116`

/**
 * @author Kyunghyun Cho
 */

fun solution(newId: String): String {
    return newId.lowercase().let { newId ->
        Regex("[^a-z0-9-_.]").replace(newId, "")
    }.let { newId ->
        Regex("\\.{2,}").replace(newId, ".")
    }.let { newId ->
        Regex("^\\.|\\.\$").replace(newId, "")
    }.let {
        it.takeIf { it.isNotEmpty() } ?: "a"
    }.let { newId ->
        Regex("^.{0,14}[^.]").find(newId)!!.value
    }.let { newId ->
        when (newId.length) {
            1 -> newId.repeat(3)
            2 -> "$newId${newId[1]}"
            else -> newId
        }
    }
}
