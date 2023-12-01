package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fixture.CarFixture;

class CarTest {
    @DisplayName("동일한 Position인지 확인한다.")
    @Test
    void compare_equals_position() {
        Car poby = CarFixture.createCarBy("poby", 1);
        Car jun = CarFixture.createCarBy("jun", 1);

        Assertions.assertTrue(poby.isEqualMaxPosition(jun));
    }
}