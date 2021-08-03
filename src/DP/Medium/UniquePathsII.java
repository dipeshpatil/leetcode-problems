package DP.Medium;

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII o = new UniquePathsII();
        int[][] obg1 = {
                {0, 1},
                {0, 0}
        }, obg2 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.uniquePathsWithObstacles(obg1),
                                o.uniquePathsWithObstacles(obg2)
                        }
                )
        );
        //  [1, 2]
    }

    int[][] dp;

    public int uniquePathsWithObstacles(int[][] grid) {
        dp = new int[grid.length][grid[0].length];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfs(0, 0, grid);
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row == grid.length || col == grid[0].length || row < 0 || col < 0 || grid[row][col] == 1)
            return 0;

        if (row == grid.length - 1 && col == grid[0].length - 1)
            return 1;

        if (dp[row][col] > -1)
            return dp[row][col];

        dp[row][col] = dfs(row + 1, col, grid) + dfs(row, col + 1, grid);

        return dp[row][col];
    }
}

// https://leetcode.com/problems/unique-paths-ii/
