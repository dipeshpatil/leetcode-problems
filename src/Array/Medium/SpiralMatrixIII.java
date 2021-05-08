package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        SpiralMatrixIII o = new SpiralMatrixIII();

        int[][] list = o.spiralMatrixIII(3, 3, 0, 0);
        for (int[] row : list)
            System.out.print(Arrays.toString(row) + " ");

        // [0, 0] [0, 1] [1, 1] [1, 0] [0, 2] [1, 2] [2, 2] [2, 1] [2, 0]
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<int[]> points = new ArrayList<>();
        int size = R * C;
        int step = 1, k;

        points.add(new int[]{r0, c0});

        while (points.size() < size) {
            k = step;
            while (k > 0) {
                ++c0;
                if (isValidBound(r0, c0, R, C))
                    points.add(new int[]{r0, c0});
                k--;
            }

            k = step;
            while (k > 0) {
                ++r0;
                if (isValidBound(r0, c0, R, C))
                    points.add(new int[]{r0, c0});
                k--;
            }

            k = ++step;
            while (k > 0) {
                --c0;
                if (isValidBound(r0, c0, R, C))
                    points.add(new int[]{r0, c0});
                k--;
            }

            k = step;
            while (k > 0) {
                --r0;
                if (isValidBound(r0, c0, R, C))
                    points.add(new int[]{r0, c0});
                k--;
            }
            ++step;
        }

        return points.toArray(new int[0][]);
    }

    private boolean isValidBound(int row, int col, int ROWS, int COLS) {
        return !(row < 0 || row >= ROWS || col < 0 || col >= COLS);
    }
}

/*
    https://leetcode.com/problems/spiral-matrix-iii/
*/
