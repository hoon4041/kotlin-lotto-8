package lotto.model

import lotto.constant.LottoRank


class LottoStore() {

    fun winningStatistics(boughtLotto: List<Lotto>, winningNumber: WinningNumber): Map<LottoRank, Int> {
        val initialStats = LottoRank.entries.associateWith { 0 }.toMutableMap()

        boughtLotto.forEach { lotto ->
            val rank = winningNumber.checkRank(lotto)
            initialStats[rank] = initialStats.getOrDefault(rank, 0) + 1
        }

        return initialStats.toMap()
    }

    fun calculateProfitRate(stats: Map<LottoRank, Int>, purchasePrice: Long): Double {
        val totalPrize = stats.entries.sumOf { (rank, count) ->
            rank.prizeAmount * count
        }

        if (purchasePrice == 0L) return 0.0

        return (totalPrize.toDouble() / purchasePrice.toDouble()) * 100.0
    }
}
