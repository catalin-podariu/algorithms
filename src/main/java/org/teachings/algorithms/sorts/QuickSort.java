package org.teachings.algorithms.sorts;

import java.util.Arrays;

import static org.teachings.algorithms.sorts.common.SortUtils.swap;

public class QuickSort {

    /*
     * Basic approach.
     * 1. Pivot Selection: Select a 'pivot' element from the array.
     * 2. Partition: Rearrange elements smaller than the pivot to its
     *    left and those greater than it to its right.
     * 3. Recursion: Recursively apply the above steps to the sub-arrays.
     *
     * Tips & Tricks
     * - In-Place: Quick Sort sorts the array in-place, requiring O(log n) additional stack space.
     * - Unstable: It's not stable, so the relative order of equal elements may change.
     */
    public static void main(String[] args) {
        new QuickSort().start();
    }

    private void start() {
        int[] input = {30, 20, 10, 6, 5, 4};
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] input, int low, int high) {
        int i = low;
        int pivot = input[high];

        for (int j = low; j < high; j++) {
            if (input[j] < pivot) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, i, high);
        return i;
    }
}
