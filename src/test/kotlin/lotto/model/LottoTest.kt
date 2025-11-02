package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    @DisplayName("정상적인 6개의 숫자로 Lotto 객체 생성시 성공")
    fun createLottoSuccess() {
        val validNumbers = listOf(1, 12, 13, 24, 25, 30)

        val lotto = Lotto(validNumbers)

        assertThat(lotto.getNumbers()).isEqualTo(validNumbers)
    }

    @Test
    @DisplayName("getNumbers() 호출 시 내부 번호 리스트를 반환")
    fun getNumbersTest() {
        val expectedNumbers = listOf(1, 12, 13, 24, 25, 30)
        val lotto = Lotto(expectedNumbers)

        val actualNumbers = lotto.getNumbers()

        assertThat(actualNumbers).isEqualTo(expectedNumbers)
    }
}