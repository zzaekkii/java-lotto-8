package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;

import java.util.*;

import static lotto.exception.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException(INVALID_COUNT);
        }

        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != LOTTO_SIZE) {
            throw new LottoException(DUPLICATED_NUMBER);
        }

        boolean invalidRange = numbers.stream()
            .anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER);

        if (invalidRange) {
            throw new LottoException(OUT_OF_RANGE);
        }
    }

    public static Lotto create() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE));
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
