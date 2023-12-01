package racingcar.fixture;

import racingcar.domain.Car;
import racingcar.domain.MoveType;
import racingcar.domain.Name;

public class CarFixture {
    public static Car createCarBy(String name, int position) {
        Car car = Car.from(Name.from(name));

        for (int i = 0; i < position; i++) {
            car.move(MoveType.MOVE);
        }
        return car;
    }

}
