package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.view.input.BonusNumber;
import lotto.view.input.PurchaseAmount;
import lotto.view.input.WinningNumbers;
import lotto.view.output.PurchaseLotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        /// TODO 1. 구매 금액 입력받기
        int amount = readAndValidateAmount();

        /// TODO 2. 구매 금액에 맞게 로또 발행
        List<Lotto> lottos = LottoGenerator.purchase(amount);

        /// TODO 3. 발행한 로또 출력
        PurchaseLotto.printLottos(lottos);

        /// TODO 4. 당첨 번호 입력받기
        Lotto winningNumbers = readAndValidateWinningNumbers();

        /// TODO 5. 보너스 번호 입력받기
        int bonusNumber = readAndValidateBonusNumber(winningNumbers);

        /// TODO 6. 당첨 여부 확인
        Map<Rank, Integer> results = LottoCalculator.calculateResults(lottos, winningNumbers, bonusNumber);

        /// TODO 7. 당첨 통계 출력

        /// TODO 8. 수익률 출력
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
