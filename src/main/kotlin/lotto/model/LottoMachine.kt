package lotto.model

class LottoMachine(private val lottoNumberGenerator: NumberGenerator) {

    fun pickLotto(): Lotto {
        val lottoNumber = lottoNumberGenerator.generateLottoNumber()
        return Lotto(lottoNumber)
    }

    fun buyLotto(purchasePrice: Long): List<Lotto> {
        // 1000원 단위로 구매 횟수 계산
        val count = (purchasePrice / 1000).toInt()

        return List(count) {
            this.pickLotto()
        }
    }
}