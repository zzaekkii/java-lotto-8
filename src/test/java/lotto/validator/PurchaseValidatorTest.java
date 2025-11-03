package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseValidatorTest {

    @Test
    void 정상_입력_통과() {
        assertThatCode(() -> PurchaseValidator.validate("5000"))
            .doesNotThrowAnyException();
    }

    @Test
    void NULL은_예외_발생() {
        assertThatThrownBy(() -> PurchaseValidator.validate(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양수를 입력");
    }

    @Test
    void 문자_포함_예외_발생() {
        assertThatThrownBy(() -> PurchaseValidator.validate("5만원"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양수를 입력");
    }

    @Test
    void 소수_입력_예외_발생() {
        assertThatThrownBy(() -> PurchaseValidator.validate("5000.5"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양수를 입력");
    }

    @Test
    void 십만원_초과_예외_발생() {
        assertThatThrownBy(() -> PurchaseValidator.validate("105000"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("최대 구매 금액은 100,000원");
    }

    @Test
    void 입력이_음수면_예외_발생() {
        assertThatThrownBy(() -> PurchaseValidator.validate("-5000"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양수를 입력");
    }

    @Test
    void 입력이_0이면_예외_발생() {
        assertThatThrownBy(() -> PurchaseValidator.validate("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("최소 1,000원 이상");
    }

    @Test
    void 천원_단위가_아니면_예외_발생() {
        assertThatThrownBy(() -> PurchaseValidator.validate("5050"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1,000원 단위로만");
    }
}