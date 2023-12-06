package racingcar.dto;

public record MatchResult(String name, int position) {

    public static MatchResult of(String name, int position) {
        return new MatchResult(name, position);
    }
}