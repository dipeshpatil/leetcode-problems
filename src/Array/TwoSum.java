package Array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        twoSum(new int[]{2, 7, 11, 15}, 26)
                )
        );
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int y;
        for (int i = 0; i < nums.length; i++) {
            y = target - nums[i];
            if (map.containsKey(y))
                return new int[]{map.get(y), i};
            map.put(nums[i], i);
        }
        throw new IllegalStateException("Solution Doesn't Exist");
    }
}

/*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.

    You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*/