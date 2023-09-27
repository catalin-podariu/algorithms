package org.teachings.gpt.structured.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        new TwoSum().start();
    }

    private void start() {
        int[] nums = new int[] {2, 3, 12, 20, 1, 2, 4, 3};
        int target = 6;
        System.out.printf("Sum of [%s], from %s, is with elements at %s", target, Arrays.toString(nums),
                Arrays.toString(twoSumHashMap(nums, target)));
    }

    public int[] twoConsecutiveNumbersSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) == target) {
                return new int[] {i, i + 1};
            }
        }
        return null;
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(complement, i);
        }
        return null;
    }
}
