package lotto.exception;

public enum ErrorMessage {
    EXCEED_MAX_PURCHASE("1회 최대 구매 금액은 100,000원 입니다."),
    NOT_DIVISIBLE("1,000원 단위로만 구매가 가능합니다."),
    NOT_NUMBER("정수를 입력해야 합니다."),
    NEGATIVE_OR_ZERO("최소 1,000원 이상 구매 가능합니다."),
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
