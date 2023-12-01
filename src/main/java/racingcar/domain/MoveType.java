package racingcar.domain;

public enum MoveType {
    MOVE(true),
    NOT_MOVE(false);

    private static final int MIN_MOVE_BOUND = 4;

    private final boolean isMove;

    MoveType(boolean isMove) {
        this.isMove = isMove;
    }

    public static MoveType valueOf(int number) {
        if (number >= MIN_MOVE_BOUND) {
            return MOVE;
        }
        return NOT_MOVE;
    }

    public boolean isMove() {
        return isMove;
    }
}
