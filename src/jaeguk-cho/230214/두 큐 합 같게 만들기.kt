package `jaeguk-cho`.`두 큐 합 같게 만들기`

/**
 * @author Jaeguk Cho
 */

class `두 큐 합 같게 만들기` {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val maxCount = queue1.size * 2
        val queueA = ArrayDeque(queue1.toList())
        val queueB = ArrayDeque(queue2.toList())
        var sizeA = queueA.sum().toLong()
        var sizeB = queueB.sum().toLong()
        var answer = 0

        while (answer != maxCount && sizeA != sizeB) {
            if (sizeA > sizeB) {
                sizeA -= queueA.first()
                sizeB += queueA.first()
                queueA transfer queueB
            } else {
                sizeA += queueB.first()
                sizeB -= queueB.first()
                queueB transfer queueA
            }
            answer++
        }

        return answer.takeIf { it != maxCount } ?: -1
    }

    private infix fun <T> ArrayDeque<T>.transfer(that: ArrayDeque<T>) {
        that.add(this.removeFirst())
    }
}
