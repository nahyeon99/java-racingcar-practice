package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.dto.MatchDto;
import racingcar.dto.NameDto;
import racingcar.util.CarsFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView,
                            OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = generateCars();
        TryCount tryCount = generateTryCount();

        match(cars, tryCount);
        printWinners(cars);
    }

    private Cars generateCars() {
        return CarsFactory.of(inputView.inputCarNames());
    }

    private TryCount generateTryCount() {
        return TryCount.from(inputView.inputTryCount());
    }

    private void match(Cars cars, TryCount tryCount) {
        outputView.printResultMessage();

        for (int idx = 0; idx < tryCount.getCount(); idx++) {
            List<MatchDto> matchOnceResult = cars.match();

            outputView.printResultOnceByAll(matchOnceResult);
        }
    }

    private void printWinners(Cars cars) {
        List<NameDto> maxPositionCars = cars.getMaxPositionCars();

        outputView.printWinners(maxPositionCars);
    }
}