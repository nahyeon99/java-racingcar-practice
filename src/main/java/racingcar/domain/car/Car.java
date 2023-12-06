package racingcar.domain.car;

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
}