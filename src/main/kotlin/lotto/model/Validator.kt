package lotto.model

import lotto.constant.ErrorType
import lotto.constant.LottoInfo

class Validator {
    fun validPurchasePrice(input: String) {
        val number =
            input.toLongOrNull() ?: throw IllegalArgumentException(ErrorType.ERROR_MESSAGE_PURCHASE_PRICE.message)

        require(number > 0 && number % 1000 == 0L) {
            ErrorType.ERROR_MESSAGE_PURCHASE_PRICE
        }
    }

    fun validWinningNumber(input: String) {
        val winningNumbers = input.split(LOTTO_NUMBER_SPLITER).map { it.trim() }
        require(winningNumbers.size == LottoInfo.LOTTO_NUMBER_SIZE.number) {
            ErrorType.ERROR_MESSAGE_SIX_LOTTO_NUMBER
        }
        val numbers = winningNumbers.map { number ->
            require(number.matches(LOTTO_NUMBER_REGEX)) {
                ErrorType.ERROR_MESSAGE_LOTTO_RANGE
            }
            number.toInt()
        }
        require(numbers.distinct().size == LottoInfo.LOTTO_NUMBER_SIZE.number) {
            ErrorType.ERROR_MESSAGE_LOTTO_DUPLICATE
        }
    }

    fun validBonusNumber(input: String, winningNumber: List<Int>) {
        require(input.matches(LOTTO_NUMBER_REGEX)) {
            ErrorType.ERROR_MESSAGE_LOTTO_DUPLICATE
        }

        val bonusNumber = input.toInt()
        require(!winningNumber.contains(bonusNumber)) {
            ErrorType.ERROR_MESSAGE_BONUS_DUPLICATE
        }
    }

    companion object {
        private val LOTTO_NUMBER_REGEX = Regex("^(?:[1-9]|[1-3][0-9]|4[0-5])$")
        private const val LOTTO_NUMBER_SPLITER = ","
    }
}