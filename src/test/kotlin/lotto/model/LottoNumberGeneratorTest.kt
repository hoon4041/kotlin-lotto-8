package lotto.model

import lotto.constant.LottoInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {

    private val lottoNumberGenerator = LottoNumberGenerator()

    @Test
    @DisplayName("generateLottoNumber 호출 시 1~45사이의 숫자 6개 생성")
    fun generateLottoNumberTest() {
        val lottoNumber = lottoNumberGenerator.generateLottoNumber()

        for (lottoNumber in lottoNumber) {
            assertThat(lottoNumber).isBetween(LottoInfo.LOTTO_NUMBER_MIN.number, LottoInfo.LOTTO_NUMBER_MAX.number)
        }
    }
}