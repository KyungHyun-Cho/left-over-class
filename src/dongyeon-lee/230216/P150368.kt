package `dongyeon-lee`.`230216`

class Solution { fun solution(s: String) = s.lowercase().split(" ").joinToString(" ") { it.take(1).uppercase() + it.drop(1) } }