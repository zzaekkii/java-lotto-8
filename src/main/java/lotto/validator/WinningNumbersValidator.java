package lotto.validator;

import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.*;

public class WinningNumbersValidator {

    public static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new LottoException(EMPTY_INPUT);
        }

        if (!input.matches("^[0-9,]+$")) {
            throw new LottoException(INVALID_FORMAT);
        }

        if (input.startsWith(",") || input.endsWith(",") || input.contains(",,")) {
            throw new LottoException(INVALID_FORMAT);
        }
    }
}
