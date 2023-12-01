package racingcar.util;

import racingcar.domain.MoveType;

public class MoveTypeGenerator {
    public static MoveType generate() {
        return MoveType.valueOf(RandomNumberGenerator.generate());
    }
}