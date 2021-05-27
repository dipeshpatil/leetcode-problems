package Array.Medium;

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII o = new SpiralMatrixII();

        int[][] matrix = o.generateMatrix(3);
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));

        //  [1, 2, 3]
        //  [8, 9, 4]
        //  [7, 6, 5]
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int layers = Math.floorDiv(n + 1, 2);
        matrixHelper(matrix, 0, n - 1, 0, n - 1, layers, 1);
        return matrix;
    }

    private void matrixHelper(int[][] matrix, int left, int right, int top, int bottom, int layers, int track) {
        for (int i = left; i <= right; i++)
            matrix[top][i] = track++;

        for (int i = top + 1; i <= bottom; i++)
            matrix[i][right] = track++;

        for (int i = right - 1; i >= left; i--)
            matrix[bottom][i] = track++;

        for (int i = bottom - 1; i >= top + 1; i--)
            matrix[i][left] = track++;

        if (layers > 0)
            matrixHelper(matrix, left + 1, right - 1, top + 1, bottom - 1, --layers, track);
    }
}

// https://leetcode.com/problems/spiral-matrix-ii/
