package org.teachings.gpt.random;

import java.util.Arrays;

public class FrequencyDistribution {

    public static void main(String[] args) {
        new FrequencyDistribution().start();
    }

    private void start() {
        String bigNumbersString = "123456789012321387423492387412093481284712403129831298345678901234567890";
        System.out.println(
                Arrays.toString(
                        frequencyDistribution(bigNumbersString)));
    }

    private int[] frequencyDistribution(String input) {
        int[] count = new int[10];

        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            count[digit]++;
        }
        return count;
    }
}
