package racingcar.domain;

import java.util.List;
import racingcar.dto.MatchDto;
import racingcar.dto.NameDto;
import racingcar.util.MoveTypeGenerator;

public class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
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
}
