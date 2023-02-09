package `dongyeon-lee`.`230209`

import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): List<Int> {
        val (dTime, dFee, pTime, pFee) = fees
        val lastOfDay = ("23:59").toMinutes()
        val parkingMap = hashMapOf<String, Int>() // 차량 번호, 시각
        val feeMap = hashMapOf<String, Int>()

        records.forEach {
            val  (t, num, _) = it.split(" ")
            val time = t.toMinutes()
            if (parkingMap.containsKey(num)) {
                val diff = time -parkingMap.getOrDefault(num, 0)
                feeMap[num] = feeMap.getOrDefault(num, 0).plus(diff)
                parkingMap.remove(num)
                return@forEach
            }
            parkingMap[num] = time
        }

        parkingMap.forEach { (num, t) ->
            val time = lastOfDay - t
            feeMap[num] = feeMap.getOrDefault(num, 0).plus(time)
        }

        return feeMap.toSortedMap().map { (_, t) ->
            t.calcFinalFee(dTime, dFee, pTime, pFee).toInt()
        }
    }
    fun String.toMinutes() = split(":").let { it[0].toInt() * 60 + it[1].toInt() }
    fun Int.calcFinalFee(dTime: Int, dFee: Int, pTime: Int, pFee: Int) =
        dFee + (ceil(minus(dTime.toDouble()).coerceAtLeast(0.0).div(pTime)))  * pFee
}