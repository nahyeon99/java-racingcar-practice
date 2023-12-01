package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.NameDto;
import racingcar.exception.ExceptionMessage;
import racingcar.fixture.CarFixture;

class CarsTest {

    @DisplayName("중복된 이름이 존재하면 예외를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"poby, jun"})
    void fail_by_duplicate_name(String name1, String name2) {
        List<Car> cars = List.of(CarFixture.createCarBy(name1, 0),
                CarFixture.createCarBy(name1, 0),
                CarFixture.createCarBy(name2, 0));

        assertThatThrownBy(() -> Cars.of(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_DUPLICATE_NAME.getKorean());
    }

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