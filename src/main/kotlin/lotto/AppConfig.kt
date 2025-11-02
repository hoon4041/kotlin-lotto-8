package lotto

import lotto.controller.Controller
import lotto.model.InputParser
import lotto.model.LottoMachine
import lotto.model.LottoNumberGenerator
import lotto.model.LottoStore
import lotto.model.Validator

class AppConfig {
    private val validator = Validator()
    private val inputParser = InputParser(validator)
    private val lottoNumberGenerator = LottoNumberGenerator()
    private val lottoMachine = LottoMachine(lottoNumberGenerator)
    private val lottoStore = LottoStore() // LottoStore가 Stateless이므로 생성자 인자가 필요 없을 수 있습니다.

    fun controller(): Controller {
        return Controller(inputParser, lottoMachine, lottoStore)
    }
}