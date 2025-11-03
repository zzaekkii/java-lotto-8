package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.view.input.BonusNumber;
import lotto.view.input.PurchaseAmount;
import lotto.view.input.WinningNumbers;
import lotto.view.output.LottoResults;
import lotto.view.output.PurchaseLotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int amount = readAndValidateAmount();

        List<Lotto> lottos = LottoGenerator.purchase(amount);
        PurchaseLotto.printLottos(lottos);

        Lotto winningNumbers = readAndValidateWinningNumbers();
        int bonusNumber = readAndValidateBonusNumber(winningNumbers);

        Map<Rank, Integer> results = LottoCalculator.calculateResults(lottos, winningNumbers, bonusNumber);
        LottoResults.printStatistics(results);

        double returnRate = LottoCalculator.calculateReturnRate(results, amount);
        LottoResults.printReturnRate(returnRate);
    }

    static int readAndValidateAmount() {
        while (true) {
            try {
                return PurchaseAmount.read();
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static Lotto readAndValidateWinningNumbers() {
        while (true) {
            try {
                return WinningNumbers.read();
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static int readAndValidateBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                return BonusNumber.read(winningNumbers);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
