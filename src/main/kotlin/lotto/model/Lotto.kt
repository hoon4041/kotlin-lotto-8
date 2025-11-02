package lotto.model

import lotto.constant.ErrorType
import lotto.constant.LottoInfo

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoInfo.LOTTO_NUMBER_SIZE.number) { ErrorType.ERROR_MESSAGE_SIX_LOTTO_NUMBER }
        require(numbers.size == numbers.distinct().size) { ErrorType.ERROR_MESSAGE_LOTTO_DUPLICATE }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }
}