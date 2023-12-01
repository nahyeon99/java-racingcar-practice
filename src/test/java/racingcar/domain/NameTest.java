package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionMessage;

class NameTest {

    @DisplayName("Name 생성 시")
    @Nested
    class create_name {

        @DisplayName("성공적으로 생성한다.")
        @ParameterizedTest
        @ValueSource(strings = {"pobi", "woni", "jun"})
        void success(String name) {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> createName(name));
        }

        @DisplayName("영어 소문자로만 구성되지 않는 이름은 예외를 반환한다.")
        @ParameterizedTest
        @ValueSource(strings = {"포비", "준", "1", "워니1", "#"})
        void fail_by_name_of_not_english_lowercase(String name) {
            Assertions.assertThatThrownBy(() -> createName(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.INVALID_NAME_FORMAT.getKorean());
        }

        @DisplayName("1~5자의 크기가 아닌 이름은 예외를 반환한다.")
        @ParameterizedTest
        @ValueSource(strings = {"nahyeon", "hyewon", ""})
        void fail_by_name_size(String name) {
            Assertions.assertThatThrownBy(() -> createName(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.INVALID_NAME_SIZE.getKorean());
        }
    }

    private Name createName(String name) {
        return Name.from(name);
    }
}