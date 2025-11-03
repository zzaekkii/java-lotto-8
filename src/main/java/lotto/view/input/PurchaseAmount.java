package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PurchaseValidator;

public class PurchaseAmount {

    public static int read() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        PurchaseValidator.validate(input);
        return Integer.parseInt(input);
    }
}
