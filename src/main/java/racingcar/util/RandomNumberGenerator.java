package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
        throw new AssertionError("생성자 호출이 불가합니다.");
    }

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    static int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}