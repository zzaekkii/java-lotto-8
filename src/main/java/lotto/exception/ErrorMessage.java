package lotto.exception;

public enum ErrorMessage {
    EXCEED_MAX_PURCHASE("1회 최대 구매 금액은 100,000원 입니다."),
    NOT_DIVISIBLE("1,000원 단위로만 구매가 가능합니다."),
    NOT_NUMBER("양수를 입력해야 합니다."),
    NEGATIVE_OR_ZERO("최소 1,000원 이상 구매 가능합니다."),
    EMPTY_INPUT("입력값이 비어 있습니다."),
    INVALID_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_FORMAT("당첨 번호는 쉼표(,)로 구분된 숫자여야 합니다."),
    DUPLICATED_NUMBER("중복된 번호가 있습니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45까지 지정가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
