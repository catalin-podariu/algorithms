package org.teachings.gpt.random;

import java.util.HashMap;

public class MajorityElement {

    /*
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     *
     * Input: nums = [3,2,3]
     * Output: 3
     */
    public static void main(String[] args) {
        new MajorityElement().start();
    }

    private void start() {
        int[] numsNoMajor = {3, 2, 3, 3, 2, 3, 4, 2, 4, 3, 2, 4};
        int[] numsMajor = {3, 2, 3, 3, 2, 3, 4, 2, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 4};
        System.out.println("The majority element is: " + findMajorityElement(numsNoMajor));
        System.out.println("The majority element is: " + findMajorityElement(numsMajor));
    }

    public int findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        // No majority element (although problem states it's always present)
        return -1;
    }

}
