package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.NameDto;
import racingcar.fixture.CarFixture;

class CarsTest {

    @DisplayName("가장 많이 전진한 Cars를 조회한다.")
    @Test
    void get_max_position_cars() {
        Car maxPositionCar1 = CarFixture.createCarBy("poby", 3);
        Car maxPositionCar2 = CarFixture.createCarBy("woni", 3);
        Car notMaxPositionCar = CarFixture.createCarBy("jun", 1);

        List<Car> cars = List.of(maxPositionCar1, maxPositionCar2, notMaxPositionCar);
        Cars matchCars = Cars.of(cars);

        List<NameDto> maxPositionCars = matchCars.getMaxPositionCars();

        Assertions.assertTrue(() -> maxPositionCars.contains(NameDto.from(maxPositionCar1)));
        Assertions.assertTrue(() -> maxPositionCars.contains(NameDto.from(maxPositionCar2)));
        Assertions.assertFalse(() -> maxPositionCars.contains(NameDto.from(notMaxPositionCar)));
    }
}