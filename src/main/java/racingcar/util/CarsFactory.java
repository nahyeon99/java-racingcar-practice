package racingcar.util;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

public class CarsFactory {
    public static Cars of(List<String> carNames) {
        List<Car> cars = createCars(createNames(carNames));

        return Cars.of(cars);
    }

    private static List<Car> createCars(List<Name> carNames) {
        return carNames.parallelStream()
                .map(Car::from)
                .toList();
    }

    private static List<Name> createNames(List<String> carNames) {
        return carNames.parallelStream()
                .map(Name::from)
                .toList();
    }
}