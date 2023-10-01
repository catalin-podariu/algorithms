package org.teachings.gpt.leetcode.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    public static void main(String[] args) {
        new TwoSum().start();
    }

    private void start() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.printf("Sum of [%s], from %s, is with elements at %s",
                target,
                Arrays.toString(nums),
                Arrays.toString(twoSumHashMap(nums, target)));
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(complement, i);
        }
        return null;
    }
}
