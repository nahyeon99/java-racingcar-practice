package racingcar.domain;

import static racingcar.exception.ExceptionMessage.INVALID_DUPLICATE_NAME;

import java.util.List;
import java.util.Objects;
import racingcar.dto.MatchDto;
import racingcar.dto.NameDto;
import racingcar.util.MoveTypeGenerator;

public class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public static Cars of(final List<Car> cars) {
        return new Cars(cars);
    }

    public List<MatchDto> match() {
        return cars.parallelStream()
                .map(car -> {
                    MoveType moveType = MoveTypeGenerator.generate();
                    return car.move(moveType);
                })
                .toList();
    }

    public List<NameDto> getMaxPositionCars() {
        Car maxPositionCar = getMaxPositionCar();

        return cars.stream()
                .filter(car -> maxPositionCar.isEqualMaxPosition(car))
                .map(NameDto::from)
                .toList();
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElse(cars.get(0));
    }

    private void validateDuplicateName(List<Car> cars) {
        int distinctCount = (int) cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NAME.getKorean());
        }
    }
}