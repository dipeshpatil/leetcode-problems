package Array.Easy;

import java.util.Arrays;

public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        CreateTargetArrayInTheGivenOrder o = new CreateTargetArrayInTheGivenOrder();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                Arrays.toString(o.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})),
                                Arrays.toString(o.createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0})),
                                Arrays.toString(o.createTargetArray(new int[]{1}, new int[]{0})),
                        }
                )
        );
        // [[0, 4, 1, 3, 2], [0, 1, 2, 3, 4], [1]]
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int idx = index[i];

            if (idx < i)
                for (int j = i; j > idx; j--)
                    result[j] = result[j - 1];

            result[idx] = nums[i];
        }

        return result;
    }
}

// https://leetcode.com/problems/create-target-array-in-the-given-order/
