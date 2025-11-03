package lotto.model

import lotto.constant.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningNumberTest {

    private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
    private val BONUS_NUMBER = 7

    private lateinit var winningNumber: WinningNumber

    @BeforeEach
    fun setUp() {
        winningNumber = WinningNumber(WINNING_NUMBERS, BONUS_NUMBER)
    }

    @ParameterizedTest(name = "로또 번호 {0}는 등수 {1}에 해당해야 한다")
    @CsvSource(
        value = [
            // 1등: 6개 일치
            "1, 2, 3, 4, 5, 6, FIRST",

            // 2등: 5개 일치 + 보너스 번호 7 일치
            "1, 2, 3, 4, 5, 7, SECOND",

            // 3등: 5개 일치 + 보너스 번호 불일치 (8)
            "1, 2, 3, 4, 5, 8, THIRD",

            // 4등: 4개 일치
            "1, 2, 3, 4, 10, 11, FOURTH",

            // 5등: 3개 일치
            "1, 2, 3, 20, 21, 22, FIFTH",

            // 꽝: 2개 일치 (30, 31)
            "1, 2, 30, 31, 32, 33, MISS"
        ]
    )
    @DisplayName("CsvSource 데이터를 사용하여 모든 로또 등수가 정확히 계산되어야 한다")
    fun checkRank_returnsCorrectLottoRank(
        n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int, expectedRankName: String
    ) {
        val lottoNumbers = listOf(n1, n2, n3, n4, n5, n6)
        val lotto = Lotto(lottoNumbers)
        val expectedRank = LottoRank.valueOf(expectedRankName)

        val actualRank = winningNumber.checkRank(lotto)

        assertThat(actualRank).isEqualTo(expectedRank)
    }
}