package utils;

import baseball.Ball;
import baseball.Balls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {



    @RepeatedTest(100)
    void createRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int randomNumber = randomNumberGenerator.createRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(Ball.MIN_NO).isLessThanOrEqualTo(Ball.MAX_NO);
    }

    @Test
    void 랜덤_숫자_사이즈() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        List<Integer> randomNumbers = randomNumberGenerator.createRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(Balls.MAX_SIZE);
    }

    @RepeatedTest(100)
    @DisplayName("랜덤 숫자 중복확인")
    void 랜덤_리스트_중복확인() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        List<Integer> randomNumbers = randomNumberGenerator.createRandomNumbers();
        System.out.println("randomNumbers = " + randomNumbers);
        assertThat(randomNumbers).containsOnlyOnce(randomNumbers.get(0));
        assertThat(randomNumbers).containsOnlyOnce(randomNumbers.get(1));
        assertThat(randomNumbers).containsOnlyOnce(randomNumbers.get(2));
    }
}