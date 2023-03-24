package `dongyeon-lee`.`230324`

/* 불량 사용자 */
class Solution {
    private lateinit var isVisited: MutableList<Boolean>
    private var set = HashSet<String>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        isVisited = MutableList(user_id.size) { false }
        dfs(0, user_id, banned_id)
        return set.size
    }
    fun dfs(depth: Int, user_id: Array<String>, banned_id: Array<String>) {
        if (depth == banned_id.size) {
            set.add(isVisited.toString()) // 같은 조합을 중복으로 선택하는 경우가 있더라구요
            return
        }
        val banned = banned_id[depth]
        user_id.forEachIndexed { index, user ->
            if (isVisited[index]) return@forEachIndexed
            user.match(banned) {
                isVisited[index] = true
                dfs(depth + 1, user_id, banned_id)
                isVisited[index] = false
            }
        }
    }
    private fun String.match(b: String, block: () -> Unit) {
        if (this.length != b.length) return
        this.zip(b) { a, b ->
            b in listOf(a, '*')
        }.firstOrNull { !it } ?: block()
    }
}