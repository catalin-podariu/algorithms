package org.teachings.gpt.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        new BinarySearch().start();
    }

    private void start() {
        int[] array = {1, 6, 3, 5, 7, 2, 4, 9};
        int target = 5;
        Arrays.sort(array); // doesn't work as expected if array is not sorted
        int result = binarySearch(array, target);
        System.out.println("The target " + target + " is at index: " + result);  // Output should be 4
    }

    public int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;  // Target not found
    }
}
