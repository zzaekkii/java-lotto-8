package lotto.validator;

import lotto.exception.LottoException;

import static lotto.exception.ErrorMessage.*;

public class PurchaseValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE = 100_000;
    private static final int MAX_LENGTH = 6;

    public static void validate(String input) {
        if (input == null || !input.matches("\\d+")) {
            throw new LottoException(NOT_NUMBER);
        }

        if (input.length() > MAX_LENGTH) {
            throw new LottoException(EXCEED_MAX_PURCHASE);
        }

        int amount = Integer.parseInt(input);

        if (amount <= 0) {
            throw new LottoException(NEGATIVE_OR_ZERO);
        }

        if (amount % LOTTO_PRICE != 0) {
            throw new LottoException(NOT_DIVISIBLE);
        }

        if (amount > MAX_PURCHASE) {
            throw new LottoException(EXCEED_MAX_PURCHASE);
        }
    }
}
