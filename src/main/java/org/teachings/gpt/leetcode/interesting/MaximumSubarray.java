package org.teachings.gpt.leetcode.interesting;

public class MaximumSubarray {

    /*
     * Given an integer array nums, find the subarray with the largest sum,
     * and return its sum.
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    public static void main(String[] args) {
        new MaximumSubarray().start();
    }

    private void start() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Sum " + maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cMax = Integer.MIN_VALUE;
        int temp = 0;

        for (int num : nums) {
            temp += num;
            cMax = Math.max(cMax, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return cMax;
    }
}
