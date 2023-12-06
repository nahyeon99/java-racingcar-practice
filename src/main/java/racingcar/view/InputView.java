package racingcar.view;

import static racingcar.util.InputUtil.readLine;
import static racingcar.util.InputUtil.readNumber;
import static racingcar.util.InputUtil.readValues;

import java.util.List;

public class InputView {

    public List<String> inputCarNames() {
        System.out.println(Message.INPUT_CAR_NAMES.korean);

        return readValues(readLine(), Message.CAR_NAME_DELIMITER.korean);
    }

    public int inputTryCount() {
        System.out.println(Message.INPUT_TRY_COUNT.korean);

        return readNumber(readLine());
    }

    private enum Message {
        INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
        CAR_NAME_DELIMITER(","),
        ;
        private String korean;

        Message(String korean) {
            this.korean = korean;
        }
    }
}