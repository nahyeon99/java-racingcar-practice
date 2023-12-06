package racingcar.exception;

public enum ExceptionMessage {
    INVALID_BLANK("필수 입력 항목입니다."),
    INVALID_NUMBER_FORMAT("정수로 입력해 주세요."),
    INVALID_NAME_FORMAT("이름은 영어 소문자로만 입력해 주세요."),
    INVALID_NAME_SIZE("이름은 1~5자의 범위로 입력해 주세요."),
    INVALID_NAMES_SIZE("이름은 2~5개의 범위로 입력해 주세요."),
    INVALID_DUPLICATE_NAME("이름은 중복 없이 입력해 주세요."),
    INVALID_TRY_COUNT_SIZE("시도 횟수는 1~10의 범위로 입력해 주세요."),
    ;

    private final String korean;

    ExceptionMessage(String message) {
        this.korean = message;
    }

    public String getKorean() {
        return korean;
    }
}
