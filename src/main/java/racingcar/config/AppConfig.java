package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public static AppConfig instance() {
        return LazyHolder.INSTANCE;
    }

    public RacingController racingController() {
        return LazyHolder.racingController;
    }

    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();
        private static final InputView inputView = createInputView();
        private static final OutputView outputView = createOutputView();
        private static final RacingController racingController = createRacingController();

        private static InputView createInputView() {
            return new InputView();
        }

        private static OutputView createOutputView() {
            return new OutputView();
        }

        private static RacingController createRacingController() {
            return new RacingController(inputView, outputView);
        }
    }
}