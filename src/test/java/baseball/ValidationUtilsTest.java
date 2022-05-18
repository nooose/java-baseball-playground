package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    @DisplayName("숫자_1_9_검증")
    void 숫자_1_9_검증() {
        Assertions.assertThat(ValidationUtils.valid(9)).isTrue();
        Assertions.assertThat(ValidationUtils.valid(1)).isTrue();
        Assertions.assertThat(ValidationUtils.valid(0)).isFalse();
        Assertions.assertThat(ValidationUtils.valid(10)).isFalse();
    }
}
