package lotto.constant

enum class LottoRank(
    val matchCount: Int,
    val needsBonus: Boolean,
    val prizeAmount: Long,
    val rankDescription: String
) {
    FIFTH(3, false, 5_000L, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000L, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000L, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    MISS(0, false, 0L, "꽝");

    companion object {
        fun getLottoRank(matchCount: Int, hasBonus: Boolean): LottoRank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (hasBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }

        }
    }
}