package org.teachings.gpt.random;

import java.util.HashMap;
import java.util.Map;

public class Fibs {

    long upperLimit = 9_223_372_036_854_775_807L;

    public static void main(String[] args) {
        new Fibs().start();
    }

    private void start() {
        Map<Long, Long> memo = new HashMap<>();
        memo.put(1L, 1L);
        memo.put(2L, 1L);

        long dibSTART = System.currentTimeMillis();
        int input = 38;
        long dibOutput = dib(input, memo);
        long dibEND = System.currentTimeMillis();
        System.out.println("This took " + (dibEND - dibSTART) + " millis and found the " + input + "th number: " + dibOutput);
    }

    /**
     * This fails starting with the 93rd number.
     * This is the 93 number: -6246583658587674878
     * <br>
     * <br>
     * You've run into a classic issue with the long type in Java: integer overflow.
     * The value of the 93rd Fibonacci number is too large to fit into a long,
     * which means that the calculations after that are also incorrect.
     * <br>
     * long in Java has a maximum value of
     * 2^63 -1 which is 9,223,372,036,854,775,807.
     * Once you exceed this limit, you'll get a wrap-around effect where
     * the value will become negative and start counting up from the lower limit.
     */
    private long dib(long n, Map<Long, Long> memo) {
        if (n == 1 || n == 2) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        long result = dib(n - 1, memo) + dib(n - 2, memo);
        memo.put(n, result);
        System.out.println("This is the " + n + " number: " + result);
        return result;
    }
}
