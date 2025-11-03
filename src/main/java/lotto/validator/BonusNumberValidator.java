package lotto.validator;

import lotto.domain.Lotto;
import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.*;

public class BonusNumberValidator {
    private static final int MAX_LENGTH = 2;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateFormat(String input) {
        if (input == null || !input.matches("\\d+")) {
            throw new LottoException(NOT_NUMBER);
        }

        if (input.length() > MAX_LENGTH) {
            throw new LottoException(OUT_OF_RANGE);
        }
    }

    public static void validateBonusNumber(int number, Lotto winningNumbers) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(OUT_OF_RANGE);
        }

        if (winningNumbers.getNumbers().contains(number)) {
            throw new LottoException(DUPLICATED_NUMBER);
        }
    }
}
