package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validator.BonusNumberValidator;

public class BonusNumber {

    public static int read(Lotto winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        BonusNumberValidator.validateFormat(input);

        int number = Integer.parseInt(input);
        BonusNumberValidator.validateBonusNumber(number, winningNumbers);

        return number;
    }
}
