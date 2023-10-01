package org.teachings.gpt.sorts;

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
        System.out.println("Delete this before writing some code.");
        // TODO cpodariu - initiate and learn this.
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}
