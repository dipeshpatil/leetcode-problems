package Array.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum o = new TwoSum();
        System.out.println(
                Arrays.toString(
                        o.twoSum(new int[]{2, 7, 11, 15}, 26)
                )
        );
    }

    public int[] twoSum(int[] nums, int target) {
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

// https://leetcode.com/problems/two-sum/
