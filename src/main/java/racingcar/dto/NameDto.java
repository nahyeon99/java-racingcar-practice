package racingcar.dto;

import racingcar.domain.Car;

public record NameDto(String name) {
    public static NameDto from(Car car) {
        return new NameDto(car.getName());
    }
}
