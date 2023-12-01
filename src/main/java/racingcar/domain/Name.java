package racingcar.domain;

import static racingcar.exception.ExceptionMessage.INVALID_NAME_FORMAT;
import static racingcar.exception.ExceptionMessage.INVALID_NAME_SIZE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    private static final Pattern carNamePattern = Pattern.compile("^[a-z]*$");
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    private Name(String name) {
        validateNameSize(name);
        validateNameFormat(name);

        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private static void validateNameFormat(String name) {
        Matcher matcher = carNamePattern.matcher(name);

        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT.getKorean());
        }
    }

    private void validateNameSize(String name) {
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE.getKorean());
        }
    }
}