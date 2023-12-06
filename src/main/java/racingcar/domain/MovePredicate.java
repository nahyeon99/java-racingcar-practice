package racingcar.domain;

import java.util.function.IntPredicate;
import racingcar.generator.NumberGenerator;

public class MovePredicate implements IntPredicate {
    private static final int MIN_MOVE_BOUND = 4;

    private final NumberGenerator numberGenerator;

    public MovePredicate(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean testRandom() {
        return test(numberGenerator.generate());
    }

    @Override
    public boolean test(int number) {
        return number > MIN_MOVE_BOUND;
    }
}
