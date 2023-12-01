package racingcar.domain;

import static racingcar.exception.ExceptionMessage.INVALID_TRY_COUNT_SIZE;

public class TryCount {
    private static final int MIN_COUNT_SIZE = 1;
    private static final int MAX_COUNT_SIZE = 15;

    private final int count;

    private TryCount(int count) {
        validateCountSize(count);
        this.count = count;
    }

    public static TryCount from(int count) {
        return new TryCount(count);
    }

    public int getCount() {
        return count;
    }

    private void validateCountSize(int count) {
        if (count < MIN_COUNT_SIZE || count > MAX_COUNT_SIZE) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_SIZE.getKorean());
        }
    }
}