package racingcar.domain;

public class Position implements Comparable<Position> {
    private int position;

    private Position() {
        this.position = 0;
    }

    public static Position from() {
        return new Position();
    }

    public void move(MoveType moveType) {
        if (moveType.isMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
    }
}