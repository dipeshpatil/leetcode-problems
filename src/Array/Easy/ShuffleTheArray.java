package Array.Easy;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        ShuffleTheArray o = new ShuffleTheArray();
        System.out.println(
                Arrays.toString(
                        o.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)
                )
        );
    }

    public int[] shuffle(int[] nums, int n) {
        int[] newNums = new int[n + n];
        for (int p1 = 0, p2 = n, i = 0; p1 < n && p2 < nums.length; p1++, p2++, i += 2) {
            newNums[i] = nums[p1];
            newNums[i + 1] = nums[p2];
        }
        return newNums;
    }
}
