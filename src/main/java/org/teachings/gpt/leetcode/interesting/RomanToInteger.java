package org.teachings.gpt.leetcode.interesting;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /*
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two ones added together.
     * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII,
     * which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four. The same principle
     * applies to the number nine, which is written as IX.
     *
     * There are six instances where subtraction is used:
     * -- I can be placed before V (5) and X (10) to make 4 and 9.
     * -- X can be placed before L (50) and C (100) to make 40 and 90.
     * -- C can be placed before D (500) and M (1000) to make 400 and 900.
     * -- Given a roman numeral, convert it to an integer.
     */
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
