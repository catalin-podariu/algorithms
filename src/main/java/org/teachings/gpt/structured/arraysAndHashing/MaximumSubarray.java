package org.teachings.gpt.structured.arraysAndHashing;

public class MaximumSubarray {

    public static void main(String[] args) {
        new MaximumSubarray().start();
    }

    private void start() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Sum " + maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
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
