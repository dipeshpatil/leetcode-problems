package Array.Easy;

import java.util.Arrays;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        FindTheHighestAltitude o = new FindTheHighestAltitude();

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.largestAltitude(new int[]{-5, 1, 5, 0, -7}),
                                o.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2})
                        }
                )
        );
        // [1, 0]
    }

    public int largestAltitude(int[] gain) {
        int[] points = new int[gain.length + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < gain.length; i++) {
            points[i + 1] = gain[i] + points[i];
            max = Math.max(max, points[i]);
        }

        max = Math.max(max, points[gain.length]);

        return max;
    }
}

// https://leetcode.com/problems/find-the-highest-altitude/
