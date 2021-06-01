package Array.Easy;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanTheCurrentNumber o = new HowManyNumbersAreSmallerThanTheCurrentNumber();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                Arrays.toString(o.smallerNumbersThanCurrent(new int[]{4, 1, 2, 2, 3})),
                                Arrays.toString(o.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})),
                                Arrays.toString(o.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7}))
                        }
                )
        );
        // [[4, 0, 1, 1, 3], [2, 1, 0, 3], [0, 0, 0, 0]]
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        int size = nums.length;

        for (int i = 0; i < size; i++)
            freq[nums[i]]++;

        for (int i = 1; i <= 100; i++)
            freq[i] += freq[i - 1];

        for (int i = 0; i < size; i++)
            nums[i] = nums[i] > 0 ? freq[nums[i] - 1] : 0;

        return nums;
    }
}

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
