package DP.Medium;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths o = new UniquePaths();

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.uniquePaths(3, 7),
                                o.uniquePaths(3, 2),
                                o.uniquePaths(7, 3),
                                o.uniquePaths(3, 3)
                        }
                )
        );
        //  [28, 3, 28, 6]
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int i = 0; i < n; i++)
            dp[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }
}

// https://leetcode.com/problems/unique-paths/
