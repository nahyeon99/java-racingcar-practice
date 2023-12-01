package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("TryCount 생성 시")
    @Nested
    class create_try_count {

        @DisplayName("성공적으로 생성한다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 6, 8, 15})
        void success(int count) {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> TryCount.from(count));
        }

        @DisplayName("1~15 범위가 아닌 정수는 예외를 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 16, 100})
        void fail_by_out_of_range_number(int count) {
            Assertions.assertThatThrownBy(() -> TryCount.from(count));
        }
    }
}