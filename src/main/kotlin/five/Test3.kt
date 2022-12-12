package five

import kotlin.math.pow

class Test3 {
    fun findLongestStr(input: Int): Int {
        val convert = convertToArray(input)
        var maxLength = 0
        convert.forEach { print("$it,") }
        convert.forEachIndexed { index, i ->
            if (i == 0) {
                maxLength = maxLength.coerceAtLeast(findLongest(index, convert))
            }
        }
        return maxLength
    }

    private fun findLongest(index: Int, inputArray: IntArray): Int {
        var left = index - 1
        while (left >= 0) {
            if (inputArray[left] == 1) {
                left--
            } else {
                break
            }
        }
        left++
        var right = index + 1
        while (right < inputArray.size) {
            if (inputArray[right] == 1) {
                right++
            } else {
                break
            }
        }
        right--
        return right - left + 1
    }

    private fun convertToArray(input: Int): IntArray {
        var index = 0
        while (2F.pow(index) < input) {
            index++
        }
        var tempInput = input
        val convertResult = IntArray(index)
        index--
        while (tempInput >= 1 && index >= 0 && index <= convertResult.size) {
            val target = 2F.pow(index).toInt()
            if (tempInput >= target) {
                tempInput -= target
                convertResult[index] = 1
            } else {
                convertResult[index] = 0
            }
            index--
        }
        return convertResult
    }

    companion object {
        fun test() {
            val test = Test3()
            println(test.findLongestStr(1775))
            println(test.findLongestStr(52))
        }
    }
}