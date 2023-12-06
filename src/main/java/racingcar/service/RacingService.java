package racingcar.service;

import racingcar.domain.MovePredicate;
import racingcar.domain.car.Cars;

public class RacingService {
    private final MovePredicate movePredicate;

    public RacingService(MovePredicate movePredicate) {
        this.movePredicate = movePredicate;
    }

    public void moveCars(Cars cars) {
        cars.moveCars(movePredicate);
    }
}
