package racingcar.domain;

import racingcar.dto.MatchDto;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position = Position.from();

    private Car(Name name) {
        this.name = name;
    }

    public static Car from(Name name) {
        return new Car(name);
    }

    public MatchDto move(MoveType moveType) {
        position.move(moveType);

        return MatchDto.of(name, position);
    }

    public String getName() {
        return name.getName();
    }

    public boolean isEqualMaxPosition(Car other) {
        return compareTo(other) == 0;
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }
}