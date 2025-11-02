package lotto.view

import lotto.constant.LottoRank
import lotto.model.Lotto

object OutputView {

    fun printBoughtLotto(boughtLotto: List<Lotto>) {
        println("${boughtLotto.size}개를 구매했습니다.")

        boughtLotto.forEach { lotto ->
            println(lotto)
        }
    }

    fun printLottoResult(stats: Map<LottoRank, Int>, profitRate: Double) {
        println("당첨 통계")
        println("---")

        LottoRank.entries
            .filter { it != LottoRank.MISS }
            .forEach { rank ->
                val count = stats.getOrDefault(rank, 0)
                println("${rank.rankDescription} - ${count}개")
            }

        val formattedProfitRate = String.format("%.1f", profitRate)
        println("총 수익률은 ${formattedProfitRate}%입니다.")
    }

}