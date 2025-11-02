package lotto.constant

private const val ERROR_PREFIX = "[ERROR]"

enum class ErrorType(val message: String) {
    ERROR_MESSAGE_PURCHASE_PRICE("${ERROR_PREFIX} 구매금액은 천 단위의 양수이어야 합니다."),
    ERROR_MESSAGE_SIX_LOTTO_NUMBER("${ERROR_PREFIX} 로또 번호는 6개여야 합니다."),
    ERROR_MESSAGE_LOTTO_RANGE("${ERROR_PREFIX} 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_MESSAGE_LOTTO_DUPLICATE("${ERROR_PREFIX} 로또 번호는 중복될 수 없습니다."),
    ERROR_MESSAGE_BONUS_DUPLICATE("${ERROR_PREFIX} 보너스 번호는 당첨 번호를 제외한 숫자이어야 합니다.");

    override fun toString(): String {
        return message
    }
}