package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(ErrorMessage error) {
        super(error.getMessage());
    }
}
