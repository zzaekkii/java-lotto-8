package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersValidatorTest {
    @Test
    void 정상_입력_통과() {
        assertThatCode(() -> WinningNumbersValidator.validate("1,2,3,4,5,6"))
            .doesNotThrowAnyException();
    }

    @Test
    void 입력값이_NULL이면_예외() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력값이 비어");
    }

    @Test
    void 입력값이_빈문자열이면_예외() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력값이 비어");
    }

    @Test
    void 문자_포함_시_예외() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,4,5,사십오"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자 형식");
    }

    @Test
    void 쉼표가_연속될_경우_예외() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자 형식");
    }

    @Test
    void 쉼표로_끝나면_예외() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate("1,2,3,4,5,6,"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자 형식");
    }

    @Test
    void 쉼표로_시작하면_예외() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(",1,2,3,4,5,6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자 형식");
    }
}