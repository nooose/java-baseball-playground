package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    public static final int MAX_NO = 9;
    public static final int MAX_SIZE = 3;

    public RandomNumberGenerator() {
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> result = new ArrayList<>();

        while (result.size() != MAX_SIZE) {
            addRandomNumber(result, createRandomNumber());
        }

        return result;
    }

    private void addRandomNumber(List<Integer> result, int randomNUmber) {
        if (hasDuplicateNumber(result, randomNUmber)) {
            addRandomNumber(result, createRandomNumber());
            return;
        }
        result.add(randomNUmber);
    }

    private boolean hasDuplicateNumber(List<Integer> result, int randomNUmber) {
        return result.contains(randomNUmber);
    }

    public int createRandomNumber() {
        return new Random().nextInt(MAX_NO) + 1;
    }
}
