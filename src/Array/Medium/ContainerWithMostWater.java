package Array.Medium;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater o = new ContainerWithMostWater();

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}),
                                o.maxArea(new int[]{1, 1}),
                                o.maxArea(new int[]{4, 3, 2, 1, 4}),
                                o.maxArea(new int[]{1, 2, 1}),
                        }
                )
        );
        // [49, 1, 16, 2]
    }

    public int maxArea(int[] height) {
        int x1 = 0, x2 = height.length - 1;
        int area = Integer.MIN_VALUE;

        while (x1 < x2) {
            int h1 = height[x1], h2 = height[x2];
            area = Math.max(area, getArea(x1, h1, x2, h2));
            if (h1 <= h2) x1++;
            else x2--;
        }

        return area;
    }

    // Brute Force Approach - TLE
    public int maxArea1(int[] height) {
        int maxArea = Integer.MIN_VALUE, area = 0;
        for (int i = 0; i < height.length; i++) {
            int h1 = height[i];
            for (int j = 0; j < height.length; j++) {
                int h2 = height[j];
                if (i != j)
                    area = Math.max(area, getArea(i, h1, j, h2));
            }
        }
        return maxArea;
    }

    private int getArea(int x1, int h1, int x2, int h2) {
        int l = Math.min(h1, h2);
        int b = x2 - x1;
        return l * b;
    }
}

// https://leetcode.com/problems/container-with-most-water/
