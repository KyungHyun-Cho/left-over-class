package `dongyeon-lee`.`230215`

const val MIN_DC_RATE = 0
const val MAX_BUDGET = 1
class Solution {
    private lateinit var buyAmount: MutableList<Int>
    private lateinit var hogengs: Array<IntArray>
    private lateinit var emties: IntArray
    private lateinit var etDcRates: MutableList<Int>
    private val dcRates = listOf(10, 20, 30, 40)
    private var maxResult = 0 to 0

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        buyAmount =  MutableList(users.size) { 0 }
        hogengs = users
        emties = emoticons
        etDcRates = MutableList(emoticons.size) { 0 }
        permutation(0)
        return intArrayOf(maxResult.first, maxResult.second)
    }
    private fun permutation(depth: Int) {
        if (depth == emties.size) {
            calcMax()
            return
        }
        emties.forEachIndexed { emtiIndex, price ->
            dcRates.forEach { rate ->
                if (etDcRates[emtiIndex] > 0) return
                etDcRates[emtiIndex] = rate
                permutation(depth + 1)
                etDcRates[emtiIndex] = 0
            }
        }

    }
    private fun calcMax() {
        var registerCount = 0
        var totalAmount = 0
        val buyAmount = MutableList(hogengs.size) { 0 }
        hogengs.forEachIndexed { userNum, hogeng ->
            etDcRates.forEachIndexed { emtiNum, rate ->
                if (rate < hogeng[MIN_DC_RATE]) return@forEachIndexed
                val amount = (emties[emtiNum] * (100 - rate)) / 100
                buyAmount[userNum] += amount
            }
        }

        buyAmount.forEachIndexed { index, amount ->
            if (amount >= hogengs[index][MAX_BUDGET]) {
                registerCount ++
            } else {
                totalAmount += amount
            }
        }

        if (maxResult.first < registerCount || (maxResult.first == registerCount && maxResult.second < totalAmount)) {
            maxResult = registerCount to totalAmount
        }

    }
}