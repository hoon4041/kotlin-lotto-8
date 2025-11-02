package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMachineTest {

    private val fixNumberGenerator = FixNumberGenerator(listOf(1, 2, 3, 4, 5, 6))
    private val lottoNumberGenerator = LottoNumberGenerator()

    @Test
    @DisplayName("pickLotto 호출 시 정상적으로 로또가 생성")
    fun pickLottoTest() {
        val lottoMachine = LottoMachine(fixNumberGenerator)
        val lotto = lottoMachine.pickLotto()
        assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    @DisplayName("buyLotto 호출 시 입력한 금액에 맞게 LottoList반환")
    fun buyLottoTest() {
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        val purchasePrice = 8000L
        val buyLotto = lottoMachine.buyLotto(purchasePrice)

        assertThat(buyLotto.size).isEqualTo(8)
    }
}