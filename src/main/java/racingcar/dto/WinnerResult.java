package racingcar.dto;

public record WinnerResult(String name) {
    public static WinnerResult of(String name) {
        return new WinnerResult(name);
    }
}
