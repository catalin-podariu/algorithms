package org.teachings.algorithms.leetcode.arraysAndHashing;

import java.util.*;

public class TopKFrequentElements {

    /*
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * You may return the answer in any order.
     *
     * Example:
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     */
    public static void main(String[] args) {
        new TopKFrequentElements().start();
    }

    private void start() {
        int[] input = {1, 1, 1, 2, 2, 3, 4, 5};
        int k = 2;
        System.out.println(Arrays.toString(getTopKFrequent(input, k)));
    }

    public int[] getTopKFrequent(int[] nums, int k) {
        // Count frequencies using a HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Use a Min-Heap to sort elements based on their frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Retrieve the k most frequent elements from the Min-Heap
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
