package org.teachings.gpt.random;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        new RomanToInteger().start();
    }

    private void start() {
        String input = "MCMXCIV";

        Map<Character, Integer> rom = new HashMap<>();
        rom.put('I', 1);
        rom.put('V', 5);
        rom.put('X', 10);
        rom.put('L', 50);
        rom.put('C', 100);
        rom.put('D', 500);
        rom.put('M', 1000);

        System.out.printf("Input [%s] means [%s]", input, romanToInt(input));
        System.out.printf("\nInput [%s] means [%s]", input, romanToInt(input, rom));
    }

    public int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = values[s.charAt(i)];
            result += (currentValue < prevValue) ? -currentValue : currentValue;
            prevValue = currentValue;
        }

        return result;
    }

    public static int romanToInt(String s, Map<Character, Integer> rom) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int currentValue = rom.get(c);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}
