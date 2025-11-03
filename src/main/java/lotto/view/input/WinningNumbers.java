package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validator.WinningNumbersValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    public static Lotto read() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        WinningNumbersValidator.validate(input);
        List<Integer> numbers = parseNumbers(input);
        return new Lotto(numbers);
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
