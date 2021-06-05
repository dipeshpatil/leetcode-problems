package Array.Easy;

import java.util.Arrays;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints o = new MinimumTimeVisitingAllPoints();

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}),
                                o.minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}})
                        }
                )
        );
        //  [7, 5]
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int[] pointA, pointB;
        int count = 0;

        for (int i = 1; i < points.length; i++) {
            pointA = points[i];
            pointB = points[i - 1];
            count += Math.max(Math.abs(pointA[0] - pointB[0]), Math.abs(pointA[1] - pointB[1]));
        }

        return count;
    }
}

// https://leetcode.com/problems/minimum-time-visiting-all-points/
