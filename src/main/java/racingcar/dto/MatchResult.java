package racingcar.dto;

import racingcar.domain.Name;
import racingcar.domain.Position;

public record MatchResult(String name, int position) {
    public static MatchResult of(Name name, Position position) {
        return new MatchResult(name.getName(), position.getPosition());
    }
}