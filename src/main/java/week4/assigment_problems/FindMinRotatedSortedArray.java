package week4.assigment_problems;

public class FindMinRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than rightmost element, min is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // Otherwise, min is in the left half including mid
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums1)); // Output: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums2)); // Output: 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums3)); // Output: 11
    }
}