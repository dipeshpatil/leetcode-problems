package Array.Medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray o = new FindFirstAndLastPositionOfElementInSortedArray();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                Arrays.toString(o.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)),
                                Arrays.toString(o.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)),
                                Arrays.toString(o.searchRange(new int[]{}, 0)),
                        }
                )
        );
        // [[3, 4], [-1, -1], [-1, -1]]
    }

    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;

        if (first <= last)
            return new int[]{first, last};

        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first_pos = nums.length;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] >= target) {
                first_pos = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return first_pos;
    }
}

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
