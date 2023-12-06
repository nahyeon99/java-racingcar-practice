package racingcar.service;

import java.util.List;
import racingcar.domain.MovePredicate;
import racingcar.domain.car.Cars;
import racingcar.dto.MatchResult;

public class RacingService {
    private final MovePredicate movePredicate;

    public RacingService(MovePredicate movePredicate) {
        this.movePredicate = movePredicate;
    }

    public List<MatchResult> moveCars(Cars cars) {
        return cars.moveCars(movePredicate);
    }
}
