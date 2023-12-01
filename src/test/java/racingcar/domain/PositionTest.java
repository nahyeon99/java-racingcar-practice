package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("전진 시 position이 정상적으로 증가한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void increase_position_when_move(int moveCount) {
        Position position = createPositionBy(moveCount);
        move(position);

        Assertions.assertEquals(position.getPosition(), moveCount + 1);
    }

    @DisplayName("position의 크기를 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2"})
    void compare_position(int thisCount, int bigger) {
        Position thisPosition = createPositionBy(thisCount);
        Position bigPosition = createPositionBy(bigger);

        Assertions.assertEquals(thisPosition.compareTo(bigPosition), thisCount - bigger);
        Assertions.assertTrue(thisPosition.compareTo(bigPosition) < 0);
    }

    private Position createPositionBy(int moveCount) {
        Position position = Position.from();
        for (int i = 0; i < moveCount; i++) {
            position.move(MoveType.MOVE);
        }
        return position;
    }

    private void move(Position position) {
        position.move(MoveType.MOVE);
    }
}