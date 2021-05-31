package Array.Medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors o = new SortColors();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                Arrays.toString(o.sortColors(new int[]{2, 0, 2, 1, 1, 0})),
                                Arrays.toString(o.sortColors(new int[]{2, 0, 1})),
                                Arrays.toString(o.sortColors(new int[]{0})),
                                Arrays.toString(o.sortColors(new int[]{1})),
                        }
                )
        );
        // [[0, 0, 1, 1, 2, 2], [0, 1, 2], [0], [1]]
    }

    // Change return Type To void and Remove return Statement on LeetCode.
    public int[] sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0)
                exch(nums, mid++, low++);
            else if (nums[mid] == 1)
                mid++;
            else if (nums[mid] == 2)
                exch(nums, mid, high--);
        }

        return nums;
    }

    // Two Pass Solution - High Time Complexity
    public void sortColors1(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;

        for (int num : nums) {
            switch (num) {
                case 0:
                    zeros++;
                    break;
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < zeros; i++)
            nums[i] = 0;
        for (int j = zeros; j < ones + zeros; j++)
            nums[j] = 1;
        for (int k = ones + zeros; k < twos + ones + zeros; k++)
            nums[k] = 2;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// https://leetcode.com/problems/sort-colors/
