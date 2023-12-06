package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.WinnerDto;

public class OutputView {

    public void printResultTitle() {
        System.out.println(Message.RESULT_TITLE.korean);
    }

    public void printResultOfOneExecuton(List<CarDto> results) {
        results.forEach(this::printResultOfOneCar);

        System.out.println();
    }

    private void printResultOfOneCar(CarDto result) {
        System.out.printf(Message.RESULT_OF_CAR_MOVING_FORMAT.korean,
                result.name(),
                Message.DELIMITER_OF_MOVING.korean.repeat(result.position()));

        System.out.println();
    }

    public void printWinners(List<WinnerDto> results) {
        String winners = results.stream()
                .map(result -> result.name())
                .collect(Collectors.joining(Message.DELIMITER_OF_WINNER.korean));

        System.out.printf(Message.RESULT_OF_WINNER_FORMAT.korean, winners);
        System.out.println();
    }

    private enum Message {
        RESULT_TITLE("실행 결과"),
        RESULT_OF_CAR_MOVING_FORMAT("%s : %s"),
        RESULT_OF_WINNER_FORMAT("최종 우승자 : %s"),
        DELIMITER_OF_MOVING("-"),
        DELIMITER_OF_WINNER(", ");
        ;
        private String korean;

        Message(String korean) {
            this.korean = korean;
        }
    }
}