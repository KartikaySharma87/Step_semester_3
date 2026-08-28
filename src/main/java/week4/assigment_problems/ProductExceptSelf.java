package week4.assigment_problems;

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Accumulate prefix products (products of all elements to the left)
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Accumulate suffix products (products of all elements to the right)
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums1))); // Output: [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums2))); // Output: [0, 0, 9, 0, 0]
    }
}