package org.teachings.gpt.leetcode.arraysAndHashing;

import java.util.*;
import java.util.stream.Collector;

public class TopKFrequentElements {

    /*
     *
     */
    public static void main(String[] args) {
        new TopKFrequentElements().start();
    }

    private void start() {
        int[] input = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(input, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Count frequencies using a HashMap
        HashMap<Integer, Integer> freqMap = new HashMap<>();
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