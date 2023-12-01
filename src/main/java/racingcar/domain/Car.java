package racingcar.domain;

import racingcar.dto.MatchDto;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position;

    private Car(Name name) {
        this.name = name;
        this.position = Position.from();
    }

    public static Car from(Name name) {
        return new Car(name);
    }

    public MatchDto move(MoveType moveType) {
        position.move(moveType);

        return MatchDto.of(name, position);
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }

    public boolean isEqualMaxPosition(Car other) {
        return compareTo(other) == 0;
    }

    public String getName() {
        return name.getName();
    }
}