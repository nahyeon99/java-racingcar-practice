package racingcar.view;

import static racingcar.util.InputUtil.*;
import static racingcar.util.InputUtil.readList;

import java.util.List;

public class InputView {

    public List<String> inputCarNames() {
        System.out.println(OutputMessage.INPUT_NAMES.message);

        return readList(readLine(), OutputMessage.NAMES_DELIMITER.message);
    }

    public int inputTryCount() {
        System.out.println(OutputMessage.INPUT_TRY_COUNT.message);

        return readNumber(readLine());
    }

    private enum OutputMessage {
        INPUT_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
        NAMES_DELIMITER(","),
        ;

        private String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
}