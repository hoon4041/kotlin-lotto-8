package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요."
    private const val ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
    private const val ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    fun enterPurchasePrice(): String {
        println(ENTER_PURCHASE_PRICE)
        return Console.readLine()
    }

    fun enterWinningNumber(): String {
        println(ENTER_WINNING_NUMBERS)
        return Console.readLine()
    }

    fun enterBonusNumber(): String {
        println(ENTER_BONUS_NUMBER)
        return Console.readLine()
    }


}