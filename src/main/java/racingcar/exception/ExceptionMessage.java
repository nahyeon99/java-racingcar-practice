package racingcar.exception;

public enum ExceptionMessage {
    INVALID_BLANK("필수 입력 항목입니다."),
    INVALID_NUMBER_FORMAT("정수로 입력해 주세요."),
    INVALID_DUPLICATE_NAME("중복된 이름이 존재합니다."),
    INVALID_NAME_FORMAT("이름은 영소문자로만 입력해 주세요."),
    INVALID_NAME_SIZE("이름은 1~5자 내에서 입력해 주세요."),
    INVALID_TRY_COUNT_SIZE("시도 횟수는 1~15자 내에서 입력해 주세요."),
    ;

    private final String korean;

    ExceptionMessage(String message) {
        this.korean = message;
    }

    public String getKorean() {
        return korean;
    }
}
