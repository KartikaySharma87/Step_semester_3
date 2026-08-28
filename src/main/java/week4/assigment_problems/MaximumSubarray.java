package week4.assigment_problems;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Kadane's algorithm: extend current subarray or start fresh at current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1)); // Output: 6

        int[] nums2 = {-3, -1, -2};
        System.out.println(maxSubArray(nums2)); // Output: -1
    }
}