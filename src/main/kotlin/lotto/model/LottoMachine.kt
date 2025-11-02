package lotto.model

import lotto.constant.LottoInfo

class LottoMachine(private val lottoNumberGenerator: NumberGenerator) {

    fun pickLotto(): Lotto {
        val lottoNumber = lottoNumberGenerator.generateLottoNumber()
        return Lotto(lottoNumber)
    }

    fun buyLotto(purchasePrice: Long): List<Lotto> {
        val count = (purchasePrice / LottoInfo.LOTTO_PRICE.number).toInt()

        return List(count) {
            this.pickLotto()
        }
    }
}