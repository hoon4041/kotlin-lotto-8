package lotto.model

class FixNumberGenerator(private val fixNumbers: List<Int>): NumberGenerator {
    override fun generateLottoNumber(): List<Int> {
        return fixNumbers
    }
}