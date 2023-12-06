package racingcar.controller;

import java.util.List;
import racingcar.domain.TryCount;
import racingcar.domain.car.Cars;
import racingcar.domain.car.CarsFactory;
import racingcar.dto.WinnerDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView,
                            OutputView outputView,
                            RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        Cars cars = generateCars();
        TryCount tryCount = generateTryCount();

        match(tryCount, cars);
        printWinners(cars);
    }

    private Cars generateCars() {
        return CarsFactory.of(inputView.inputCarNames());
    }

    private TryCount generateTryCount() {
        return TryCount.from(inputView.inputTryCount());
    }

    private void match(TryCount tryCount, Cars cars) {
        outputView.printResultTitle();

        for (int i = 0; i < tryCount.getCount(); i++) {
            racingService.moveCars(cars);
            outputView.printResultOfOneExecuton(cars.getCars());
        }
    }

    private void printWinners(Cars cars) {
        List<WinnerDto> winnerResults = calculateWinners(cars);

        outputView.printWinners(winnerResults);
    }

    private List<WinnerDto> calculateWinners(Cars cars) {
        return cars.getWinners();
    }
}