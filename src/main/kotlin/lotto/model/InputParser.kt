package lotto.model

class InputParser(private val validator: Validator) {

    fun purchasePriceParse(input: String): Long {
        validator.validPurchasePrice(input)
        return input.toLong()
    }

    fun winningNumberParse(input: String): List<Int> {
        validator.validWinningNumber(input)
        return toIntList(input)
    }

    fun bonusNumberParse(input: String, winningNumber: List<Int>): Int {
        validator.validBonusNumber(input, winningNumber)
        return input.toInt()
    }

    fun toIntList(input: String): List<Int> {
        return input.split(",").map { it.toInt() }
    }
}