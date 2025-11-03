package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    public static Map<Rank, Integer> calculateResults(List<Lotto> purchased, Lotto winning, int bonusNumber) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Lotto lotto : purchased) {
            int matchCount = (int) lotto.getNumbers().stream()
                .filter(winning.getNumbers()::contains)
                .count();

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, bonusMatch);

            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return results;
    }
}
