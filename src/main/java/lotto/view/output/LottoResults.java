package lotto.view.output;

import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.Map;

public class LottoResults {

    public static void printStatistics(Map<Rank, Integer> results) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        DecimalFormat formatter = new DecimalFormat("#,###");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;

            String reward = formatter.format(rank.getReward());
            int count = results.getOrDefault(rank, 0);

            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", rank.getMatchCount(), reward, count);
                continue;
            }

            System.out.printf("%d개 일치 (%s원) - %d개%n", rank.getMatchCount(), reward, count);
        }
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }
}
