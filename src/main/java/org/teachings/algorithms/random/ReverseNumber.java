package org.teachings.algorithms.random;

import java.util.Arrays;

public class ReverseNumber {

    public static void main(String[] args) {
        new ReverseNumber().start();
    }

    private void start() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseNumber(input);
//        reverseNumber();
    }
    private void reverseNumber(int[] input) {
        System.out.println("Initial state:  " + Arrays.toString(input));
        reverse(input);
        System.out.println("Reversed array: " + Arrays.toString(input));
    }

    private void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    private void reverseNumber() {
        int input = 123456789;
        int reversed = 0;
        while (input != 0) {
            reversed = reversed * 10 + input % 10;
            input /= 10;
        }
        System.out.println(reversed);
    }
}
