package lotto.controller

import lotto.model.InputParser
import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.model.LottoStore
import lotto.model.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView


class Controller(
    private val inputParser: InputParser, private val lottoMachine: LottoMachine, private val store: LottoStore
) {

    fun run() {
        val purchaseResult = readInputSafely { buyLotto() }
        val boughtLotto = purchaseResult.boughtLotto
        val purchasePrice = purchaseResult.purchasePrice

        val winningNumber = readInputSafely { setupWinningNumbers() }

        processAndOutputResult(boughtLotto, winningNumber, purchasePrice)
    }

    private fun buyLotto(): LottoPurchaseResult {
        val inputPurchasePrice = InputView.enterPurchasePrice()
        val purchasePrice = inputParser.purchasePriceParse(inputPurchasePrice)
        val boughtLotto = lottoMachine.buyLotto(purchasePrice)

        OutputView.printBoughtLotto(boughtLotto)

        return LottoPurchaseResult(boughtLotto, purchasePrice)
    }

    private fun setupWinningNumbers(): WinningNumber {
        val inputWinningNumber = InputView.enterWinningNumber()
        val winningNumberParse = inputParser.winningNumberParse(inputWinningNumber)

        val inputBonusNumber = InputView.enterBonusNumber()
        val bonusNumberParse = inputParser.bonusNumberParse(inputBonusNumber, winningNumberParse)

        return WinningNumber(winningNumberParse, bonusNumberParse)
    }

    private fun processAndOutputResult(
        boughtLotto: List<Lotto>, winningNumber: WinningNumber, purchasePrice: Long
    ) {
        val result = store.winningStatistics(boughtLotto, winningNumber)
        val profitRate = store.calculateProfitRate(result, purchasePrice)

        OutputView.printLottoResult(result, profitRate)
    }

    private fun <T> readInputSafely(action: () -> T): T {
        while (true) {
            try {
                return action() // 💡 성공 시 결과 반환 및 루프 탈출
            } catch (e: IllegalArgumentException) {
                // 💡 [ERROR] 메시지 출력 후 재입력 (while 루프 재시작)
                println(e.message)
            } catch (e: IllegalStateException) {
                // 💡 추가적인 명확한 예외 유형 처리
                println(e.message)
            }
        }
    }
}