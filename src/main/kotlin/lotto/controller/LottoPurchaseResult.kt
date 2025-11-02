package lotto.controller

import lotto.model.Lotto

data class LottoPurchaseResult(
    val boughtLotto: List<Lotto>, val purchasePrice: Long
)
