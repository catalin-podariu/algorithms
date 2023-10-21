package org.teachings.algorithms.random;

public class MinMaxSum {

    /* Given five positive integers, find the minimum and maximum values that can be calculated
     * by summing exactly four of the five integers. Then print the respective minimum and maximum
     * values as a single line of two space-separated long integers.
     */
    public static void main(String[] args) {
        new MinMaxSum().start();
    }

    private void start() {
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(getMinMaxSum(input)); // expected "10 14"
    }

    private String getMinMaxSum(int[] input) {
        if (input.length == 0) return "";
        int totalSum = 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : input) {
            totalSum += num;
            if (num < minVal) minVal = num;
            if (num > maxVal) maxVal = num;
        }

        int minSum = totalSum - maxVal;
        int maxSum = totalSum - minVal;

        return minSum + " " + maxSum;
    }
}
