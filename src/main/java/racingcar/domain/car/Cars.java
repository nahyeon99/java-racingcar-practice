package racingcar.domain.car;

import java.util.List;
import racingcar.exception.ExceptionMessage;

public class Cars {
    private static final int MIN_CARS_SIZE = 2;
    private static final int MAX_CARS_SIZE = 5;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCarsSize(cars.size());
        validateDuplicateCarsByName(cars);

        this.cars = cars;
    }

    static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateCarsSize(int size) {
        if (size < MIN_CARS_SIZE || size > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAMES_SIZE.getKorean());
        }
    }

    private void validateDuplicateCarsByName(List<Car> cars) {
        if ((int) cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DUPLICATE_NAME.getKorean());
        }
    }
}