package org.teachings.gpt.leetcode.arraysAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {

    /*
     * Given an integer array nums, return true if any value appears at least
     * twice in the array, and return false if every element is distinct.
     *
     * Input: nums = [1,2,3,1]
     * Output: true
     */
    public static void main(String[] args) {
        new ContainsDuplicate().start();
    }

    private void start() {
        int[] input = {1, 2, 3, 1};

        if (containsDuplicate(input)) {
            System.out.println("Duplicate found.");
        } else {
            System.out.println("Duplicate NOT found.");
        }
    }

    private boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
