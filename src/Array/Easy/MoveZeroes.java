package Array.Easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes o = new MoveZeroes();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        o.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
        // [1, 3, 12, 0, 0]
    }

    public void moveZeroes(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[count++] = nums[i];

        while (count < nums.length)
            nums[count++] = 0;
    }
}

// https://leetcode.com/problems/move-zeroes/
