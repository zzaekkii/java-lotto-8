package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
