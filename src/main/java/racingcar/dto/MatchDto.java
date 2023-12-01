package racingcar.dto;

import racingcar.domain.Name;
import racingcar.domain.Position;

public record MatchDto(String name, int position) {
    public static MatchDto of(Name name, Position position) {
        return new MatchDto(name.getName(), position.getPosition());
    }
}
