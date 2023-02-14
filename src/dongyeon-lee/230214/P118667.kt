package `dongyeon-lee`.`230214`

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0
        val q1 = ArrayDeque(queue1.toList())
        val q2 = ArrayDeque(queue2.toList())
        var sumOfq1 = q1.sum().toLong()
        var sumOfq2 = q2.sum().toLong()
        while (answer <= queue1.size * 2 + 10) {
            if (sumOfq1 > sumOfq2) {
                val element = q1.removeFirst()
                q2.addLast(element)
                sumOfq1 -= element
                sumOfq2 += element
            } else if (sumOfq2 > sumOfq1) {
                val element = q2.removeFirst()
                q1.addLast(element)
                sumOfq2 -= element
                sumOfq1 += element
            } else return answer
            answer++
        }
        return -1
    }
}