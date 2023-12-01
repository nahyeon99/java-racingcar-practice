package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveTypeTest {

    @DisplayName("4~9 범위의 정수는 MOVE 을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void is_move_type(int number) {
        MoveType moveType = MoveType.valueOf(number);

        Assertions.assertEquals(moveType, MoveType.MOVE);
        Assertions.assertTrue(moveType.isMove());
    }

    @DisplayName("1~3 범위의 정수는 NOT_MOVE 을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void is_not_move_type(int number) {
        MoveType moveType = MoveType.valueOf(number);

        Assertions.assertEquals(moveType, MoveType.NOT_MOVE);
        Assertions.assertFalse(moveType.isMove());
    }
}