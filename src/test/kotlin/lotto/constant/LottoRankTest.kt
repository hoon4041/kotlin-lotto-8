package lotto.constant

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoRankTest {

    @ParameterizedTest(name = "일치 {0}개, 보너스 {1}일 때 {2} 등급을 반환")
    @CsvSource(
        value = [
            // 6개 일치 -> 1등 (FIRST)
            "6, false, FIRST",

            // 5개 일치 + 보너스 -> 2등 (SECOND)
            "5, true, SECOND",

            // 5개 일치 -> 3등 (THIRD)
            "5, false, THIRD",

            // 4개 일치 -> 4등 (FOURTH)
            "4, false, FOURTH",

            // 3개 일치 -> 5등 (FIFTH)
            "3, false, FIFTH",

            // 2개 일치 -> 꽝 (MISS)
            "2, false, MISS",

            // 0개 일치 -> 꽝 (MISS)
            "0, true, MISS" // 꽝일 때는 보너스 유무 무관
        ]
    )
    @DisplayName("일치 개수와 보너스 유무에 따라 정확한 등수를 반환")
    fun getLottoRank_returnsCorrectRank(
        matchCount: Int,
        hasBonus: Boolean,
        expectedRankName: String
    ) {
        val expectedRank = LottoRank.valueOf(expectedRankName)

        val actualRank = LottoRank.getLottoRank(matchCount, hasBonus)

        assertThat(actualRank).isEqualTo(expectedRank)
    }

    @ParameterizedTest(name = "{0} 등급의 상금은 {1}원이고, 설명은 {2}이다")
    @CsvSource(
        value = [
            "FIRST|2000000000|6개 일치 (2,000,000,000원)",
            "SECOND|30000000|5개 일치, 보너스 볼 일치 (30,000,000원)",
            "THIRD|1500000|5개 일치 (1,500,000원)",
            "FOURTH|50000|4개 일치 (50,000원)",
            "FIFTH|5000|3개 일치 (5,000원)",
            "MISS|0|꽝"
        ],
        delimiter = '|'
    )
    @DisplayName("각 등수의 상금과 설명이 Enum 정의와 정확히 일치해야 한다")
    fun lottoRank_hasCorrectPrizeAndDescription(
        rankName: String,
        expectedPrize: Long,
        expectedDescription: String
    ) {
        val rank = LottoRank.valueOf(rankName)

        assertThat(rank.prizeAmount).isEqualTo(expectedPrize)
        assertThat(rank.rankDescription).isEqualTo(expectedDescription)
    }
}
