package org.teachings.algorithms.search;

import java.util.Arrays;

public class BinarySearch {

    /*
     * Given an array of integers nums which is sorted in ascending order, and an integer target,
     * write a function to search target in nums. If target exists, then return its index.
     * Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     */

    public static void main(String[] args) {
        new BinarySearch().start();
    }

    private void start() {
        int[] array = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        Arrays.sort(array); // doesn't work as expected if array is not sorted
        int result = search(array, target);
        System.out.printf("The target [%s] is at index [%s]\n", target, result);  // Output should be 4
    }

    public int search(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // preventing potential overflow

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
