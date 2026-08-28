package week4.assigment_problems;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1); // Base case: prefix sum of 0 occurs once before array starts

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if there is a previous prefix sum such that currentSum - prefixSum = k
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }

            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2)); // Output: 2

        int[] nums2 = {1, -1, 0};
        System.out.println(subarraySum(nums2, 0)); // Output: 3
    }
}