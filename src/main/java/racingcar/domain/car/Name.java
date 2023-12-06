package racingcar.domain.car;

import static racingcar.exception.ExceptionMessage.INVALID_NAME_SIZE;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.ExceptionMessage;

public class Name {
    private static final Pattern namePattern = Pattern.compile("^[a-z]*$");
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    private Name(String name) {
        validateNameSize(name);
        validateNameFormat(name);

        this.name = name;
    }
    
    static Name from(String name) {
        return new Name(name);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Name)) {
            return false;
        }
        Name that = (Name) other;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    String getName() {
        return name;
    }

    private void validateNameSize(String name) {
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE.getKorean());
        }
    }
    
    private void validateNameFormat(String name) {
        Matcher matcher = namePattern.matcher(name);

        if (!matcher.find()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME_FORMAT.getKorean());
        }
    }
}