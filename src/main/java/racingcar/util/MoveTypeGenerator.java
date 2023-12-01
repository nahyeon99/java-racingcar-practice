package racingcar.util;

import racingcar.domain.MoveType;

public class MoveTypeGenerator {

    private MoveTypeGenerator() {
        throw new AssertionError("생성자 호출이 불가합니다.");
    }

    public static MoveType generate() {
        return MoveType.valueOf(RandomNumberGenerator.generate());
    }
}