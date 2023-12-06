package racingcar.dto;

public record WinnerDto(String name) {
    public static WinnerDto of(String name) {
        return new WinnerDto(name);
    }
}
