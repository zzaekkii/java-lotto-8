package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberValidatorTest {

    @Test
    void 문자_입력_예외() {
        assertThatThrownBy(() -> BonusNumberValidator.validateFormat("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("양수를 입력해야");
    }

    @Test
    void 범위를_벗어나면_예외() {
        Lotto winning = new Lotto(java.util.List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(50, winning))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1부터 45까지");
    }

    @Test
    void 당첨_번호와_중복되면_예외() {
        Lotto winning = new Lotto(java.util.List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(3, winning))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 번호");
    }

}