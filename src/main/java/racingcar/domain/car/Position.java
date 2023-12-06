package racingcar.domain.car;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    static Position from() {
        return new Position(0);
    }

    int getPosition() {
        return position;
    }

    void increase() {
        position++;
    }
}
