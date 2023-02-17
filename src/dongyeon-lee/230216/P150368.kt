package `dongyeon-lee`.`230216`

class Solution { fun solution(s: String) = s.lowercase().split(" ").joinToString(" ") { it.replaceFirstChar(Char::uppercase) } }