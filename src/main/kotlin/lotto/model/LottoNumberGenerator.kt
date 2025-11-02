package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.constant.LottoInfo

class LottoNumberGenerator : NumberGenerator {
    override fun generateLottoNumber(): List<Int> {
        return pickUniqueNumbersInRange(
            LottoInfo.LOTTO_NUMBER_MIN.number,
            LottoInfo.LOTTO_NUMBER_MAX.number,
            LottoInfo.LOTTO_NUMBER_SIZE.number
        )
    }
}