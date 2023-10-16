package org.teachings.gpt.sorts;

import java.util.Arrays;

public class MergeSortArray {

    public static void main(String[] args) {
        new MergeSortArray().start();
    }

    private void start() {
        int[] input = {30, 20, 10, 6, 5, 4};
        int arrayOneLength = input.length;
        System.out.println(Arrays.toString(input));
        mergeSort(input, 0, arrayOneLength - 1);
        System.out.println(Arrays.toString(input));
    }

    private void mergeSort(int[] input, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            mergeSort(input, leftIndex, middleIndex);
            mergeSort(input, middleIndex + 1, rightIndex);
            merge(input, leftIndex, middleIndex, rightIndex);
        }
    }

    private void merge(int[] input, int leftIndex, int middleIndex, int rightIndex) {
        // Calculate sizes of sub-arrays to be merged
        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        // Create temporary arrays for left and right sub-arrays
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) { // System.arraycopy(input, leftIndex, left, 0, leftSize);
            left[i] = input[leftIndex + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = input[middleIndex + 1 + j];
        }

        // Merge the temporary arrays back into the original input
        int i = 0, j = 0, k = leftIndex;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            }
            else {
                input[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of left
        while (i < leftSize) {
            input[k] = left[i];
            i++;
            k++;
        }
        // Copy any remaining elements of right
        while (j < rightSize) {
            input[k] = right[j];
            j++;
            k++;
        }
    }
}
