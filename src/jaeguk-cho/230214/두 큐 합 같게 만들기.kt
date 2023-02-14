package `jaeguk-cho`.`두 큐 합 같게 만들기`

/**
 * @author Jaeguk Cho
 */

class `두 큐 합 같게 만들기` {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val queueA = ArrayDeque(queue1.toList())
        val queueB = ArrayDeque(queue2.toList())
        var sizeA = queueA.sum().toLong()
        var sizeB = queueB.sum().toLong()
        var answer = 0

        while (sizeA != sizeB) {
            if (sizeA > sizeB) {
                sizeA -= queueA.first()
                sizeB += queueA.first()
                queueB.add(queueA.removeFirst())
                answer++
            } else {
                sizeA += queueB.first()
                sizeB -= queueB.first()
                queueA.add(queueB.removeFirst())
                answer++
            }

            if (answer == queue1.size * 2) break
        }

        return answer.takeIf { it != queue1.size * 2 } ?: -1
    }
}
