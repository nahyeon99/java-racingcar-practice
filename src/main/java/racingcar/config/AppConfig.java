package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.MovePredicate;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig implements Config {

    public static AppConfig instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public RacingController racingController() {
        return LazyHolder.racingController;
    }

    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();

        private static final InputView inputView = createInputView();
        private static final OutputView ouputView = createOuputView();


        private static final NumberGenerator numberGenerator = createNumberGenrator();
        private static final MovePredicate movePredicate = createMovePredicate();
        private static final RacingService racingService = createRacingService();
        private static final RacingController racingController = createBaseController();

        private static InputView createInputView() {
            return new InputView();
        }

        private static OutputView createOuputView() {
            return new OutputView();
        }

        private static NumberGenerator createNumberGenrator() {
            return new RandomNumberGenerator();
        }

        private static MovePredicate createMovePredicate() {
            return new MovePredicate(numberGenerator);
        }

        private static RacingService createRacingService() {
            return new RacingService(movePredicate);
        }

        private static RacingController createBaseController() {
            return new RacingController(inputView, ouputView, racingService);
        }
    }
}
