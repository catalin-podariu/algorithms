package org.teachings.gpt.sorts;

public class DualPivotQuickSort {

    /*
     * Dual-Pivot Quicksort Overview
     *
     * Unlike standard quicksort, which uses a single pivot to partition the array, dual-pivot quicksort
     * uses two pivots. This results in dividing the array into three parts: elements smaller than
     * the smaller pivot, elements between the pivots, and elements larger than the larger pivot.
     * This often speeds up the sorting process.
     */
    public static void main(String[] args) {
        new DualPivotQuickSort().start();
    }

    private void start() {
        int[] arr = {24, 8, 42, 75, 29, 77, 38, 57};
        dualPivotQuickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 8 24 29 38 42 57 75 77
    }

    public void dualPivotQuickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        // Ensure the lower pivot is less than or equal to the higher pivot
        if (arr[lowIndex] > arr[highIndex]) {
            swap(arr, lowIndex, highIndex);
        }

        int lessThanPivot1Index = lowIndex + 1;
        int greaterThanPivot2Index = highIndex - 1;

        int currentIndex = lowIndex + 1;

        int pivot1 = arr[lowIndex];
        int pivot2 = arr[highIndex];

        while (currentIndex <= greaterThanPivot2Index) {
            if (arr[currentIndex] < pivot1) {
                swap(arr, currentIndex++, lessThanPivot1Index++);
            } else if (arr[currentIndex] > pivot2) {
                swap(arr, currentIndex, greaterThanPivot2Index--);
            } else {
                currentIndex++;
            }
        }

        // Place the pivots into their correct positions
        swap(arr, lowIndex, lessThanPivot1Index - 1);
        swap(arr, highIndex, greaterThanPivot2Index + 1);

        // Recursively sort the three sub-arrays
        dualPivotQuickSort(arr, lowIndex, lessThanPivot1Index - 2);
        dualPivotQuickSort(arr, lessThanPivot1Index, greaterThanPivot2Index);
        dualPivotQuickSort(arr, greaterThanPivot2Index + 2, highIndex);
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
