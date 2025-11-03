package lotto.view.output;

import lotto.domain.Lotto;

import java.util.List;

public class PurchaseLotto {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");

        lottos.forEach(System.out::println);
    }
}
