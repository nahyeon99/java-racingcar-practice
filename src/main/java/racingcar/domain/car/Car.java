package racingcar.domain.car;

import racingcar.domain.MovePredicate;

public class Car {
    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    static Car of(String name) {
        return new Car(Name.from(name), Position.from());
    }

    void move(MovePredicate movePredicate) {
        if (movePredicate.testRandom()) {
            position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    boolean isPosition(int position) {
        return this.position.getPosition() == position;
    }
}