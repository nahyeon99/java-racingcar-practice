package racingcar.domain.car;

import java.util.List;

public class CarsFactory {
    public static Cars of(List<String> names) {
        return Cars.of(splitCar(names));
    }

    private static List<Car> splitCar(List<String> names) {
        return names.stream()
                .map(Car::of)
                .toList();
    }
}
