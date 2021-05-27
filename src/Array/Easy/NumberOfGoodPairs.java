package Array.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        NumberOfGoodPairs o = new NumberOfGoodPairs();

        System.out.println(
                Arrays.toString(new int[]{
                        o.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}),
                        o.numIdenticalPairs(new int[]{1, 1, 1, 1}),
                        o.numIdenticalPairs(new int[]{1, 2, 3}),
                        o.numIdenticalPairs(new int[]{6, 5, 1, 5, 7, 7, 9, 1, 5, 7, 1, 6, 10, 9, 7, 4, 1, 8, 7, 1, 1, 8, 6, 4, 7, 4, 10, 5, 3, 9, 10, 1, 9, 5, 5, 4, 1, 7, 4, 2, 9, 2, 6, 6, 4, 2, 10, 3, 5, 3, 6, 4, 7, 4, 6, 4, 4, 6, 3, 4, 10, 1, 10, 6, 10, 4, 9, 6, 6, 4, 8, 6, 9, 5, 4})
                })
        );

        // [4, 6, 0, 303]
    }

    public int numIdenticalPairs(int[] nums) {
        int count = 0, freq = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        for (Integer x : freqMap.keySet()) {
            freq = freqMap.get(x);
            count += freq * (freq - 1) / 2;
        }

        return count;
    }
}

// https://leetcode.com/problems/number-of-good-pairs/
