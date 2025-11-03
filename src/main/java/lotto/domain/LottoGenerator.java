package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> purchase(int amount) {
        int count = amount / LOTTO_PRICE;

        return IntStream.range(0, count)
            .mapToObj(i -> Lotto.create())
            .collect(Collectors.toList());
    }
}
