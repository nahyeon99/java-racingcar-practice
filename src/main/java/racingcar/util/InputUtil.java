package racingcar.util;

import static racingcar.exception.ExceptionMessage.INVALID_BLANK;
import static racingcar.exception.ExceptionMessage.INVALID_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InputUtil {
    public static int readNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getKorean());
        }
    }

    public static String readLine() {
        String input = Console.readLine();

        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INVALID_BLANK.getKorean());
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_BLANK.getKorean());
        }
        return input;
    }

    public static List<String> readList(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .toList();
    }
}