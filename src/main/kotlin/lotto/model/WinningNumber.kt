package lotto.model

import lotto.constant.LottoRank

class WinningNumber(private val numbers: List<Int>, private val bonusNumber: Int) {

    fun checkRank(lotto: Lotto): LottoRank {
        val lottoNumbers = lotto.getNumbers()
        val matchCount = lottoNumbers.intersect(this.numbers.toSet()).size
        val hasBonus = lottoNumbers.contains(this.bonusNumber)

        return LottoRank.getLottoRank(matchCount, hasBonus)
    }
}
