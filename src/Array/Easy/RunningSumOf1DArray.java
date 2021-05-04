package Array.Easy;

import java.util.Arrays;

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        RunningSumOf1DArray o = new RunningSumOf1DArray();
        System.out.println(
                Arrays.toString(
                        o.runningSum(new int[]{1, 2, 3, 4})
                )
        );
    }

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}

/*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
 */