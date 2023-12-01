package racingcar.view;

import java.util.List;
import racingcar.dto.MatchDto;
import racingcar.dto.NameDto;

public class OutputView {

    public void printResultMessage() {
        System.out.println();
        System.out.println(OutputMessage.RESULT_MESSAGE.message);
    }

    public void printResultOnceByAll(List<MatchDto> matchDtos) {
        matchDtos.forEach(this::printResultOnceByOne);
        System.out.println();
    }

    public void printWinners(List<NameDto> nameDtos) {
        String names = String.join(OutputMessage.WINNER_DELEMITER.message,
                nameDtos.stream()
                        .map(nameDto -> nameDto.name())
                        .toList());

        System.out.printf(OutputMessage.RESULT_FORMAT.message, OutputMessage.WINNER_MESSAGE.message, names);
        System.out.println();
    }

    private void printResultOnceByOne(MatchDto matchDto) {
        System.out.printf(OutputMessage.RESULT_FORMAT.message,
                matchDto.name(),
                generatePositionFormat(matchDto.position()));

        System.out.println();
    }

    private String generatePositionFormat(int position) {
        return OutputMessage.RESULT_DELEMITER.message.repeat(position);
    }

    private enum OutputMessage {
        RESULT_MESSAGE("실행 결과"),
        RESULT_FORMAT("%s : %s"),
        RESULT_DELEMITER("-"),
        WINNER_DELEMITER(", "),
        WINNER_MESSAGE("최종 우승자")
        ;

        private String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
}