package racingcar.domain.car;

import racingcar.dto.MatchResult;

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

    MatchResult move() {
        position.increase();

        return MatchResult.of(name.getName(), position.getPosition());
    }

    int getPosition() {
        return position.getPosition();
    }

    String getName() {
        return name.getName();
    }

    boolean isPosition(int position) {
        return this.position.getPosition() == position;
    }
}