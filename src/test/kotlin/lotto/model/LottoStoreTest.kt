package lotto.model

import lotto.constant.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoStoreTest {

    private lateinit var lottoStore: LottoStore

    @BeforeEach
    fun setUp() {
        lottoStore = LottoStore()
    }

    @Test
    @DisplayName("구매한 로또의 당첨여부를 올바르게 반환")
    fun winningStatisticsTest() {
        val winningNumbers = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7)
        val boughtLotto = listOf(
            Lotto(listOf(1,2,3,10,11,12)),
            Lotto(listOf(1,2,3,4,11,12)),
            Lotto(listOf(1,2,13,10,11,12)),
            Lotto(listOf(1,2,3,20,21,22))
        )

        val resultStats = lottoStore.winningStatistics(boughtLotto, winningNumbers)

        // 5등 (FIFTH) 2개, 4등 (FOURTH) 1개, 꽝 (MISS) 1개인지 확인
        assertThat(resultStats[LottoRank.FIFTH]).isEqualTo(2)
        assertThat(resultStats[LottoRank.FOURTH]).isEqualTo(1)
        assertThat(resultStats[LottoRank.MISS]).isEqualTo(1)

        // 다른 등수는 모두 0인지 확인
        assertThat(resultStats[LottoRank.THIRD]).isEqualTo(0)
        assertThat(resultStats[LottoRank.SECOND]).isEqualTo(0)
        assertThat(resultStats[LottoRank.FIRST]).isEqualTo(0)
    }

    @Test
    @DisplayName("통계와 구매 금액을 기반으로 정확한 수익률을 계산")
    fun calculateProfitRateToCorrectRate() {
        val purchasePrice = 8000L
        val stats = mapOf(
            LottoRank.FIFTH to 1,
            LottoRank.FOURTH to 1,
            LottoRank.MISS to 6
        )

        // 총 상금: 5000 + 50000 = 55000
        // 수익률: 55000 / 8000 * 100 = 687.5%
        val expectedProfitRate = 687.5

        val actualProfitRate = lottoStore.calculateProfitRate(stats, purchasePrice)
        assertThat(actualProfitRate).isEqualTo(expectedProfitRate)
    }

    @Test
    @DisplayName("구매 금액이 0일 때 수익률은 0.0을 반환")
    fun calculateProfitRate_returnsZeroToZeroPurchase() {
        // Given
        val totalPrizeAmount = 55000L

        // 이 테스트를 위해서는 LottoRank에 prizeAmount가 정의되어 있어야 함.
        val stats = mapOf(LottoRank.FIFTH to 1, LottoRank.FOURTH to 1)
        val purchasePrice = 0L // 구매 금액이 0

        // When
        val actualProfitRate = lottoStore.calculateProfitRate(stats, purchasePrice)

        // Then
        assertThat(actualProfitRate).isEqualTo(0.0)
    }
}