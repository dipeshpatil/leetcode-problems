package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes o = new SetMatrixZeroes();
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        o.setZeroes(matrix);
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));

        //  [0, 0, 0, 0]
        //  [0, 4, 5, 0]
        //  [0, 3, 1, 0]
    }

    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> zeroesList = lookZeroes(matrix);

        for (int[] x : zeroesList)
            makeRowAndColumnZero(matrix, x);
    }

    private ArrayList<int[]> lookZeroes(int[][] matrix) {
        ArrayList<int[]> zeroesList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0)
                    zeroesList.add(new int[]{i, j});

        return zeroesList;
    }

    private void makeRowAndColumnZero(int[][] matrix, int[] pair) {
        int row = pair[0], col = pair[1];

        for (int i = 0; i < matrix[0].length; i++)
            matrix[row][i] = 0;
        for (int j = 0; j < matrix.length; j++)
            matrix[j][col] = 0;
    }
}

// https://leetcode.com/problems/set-matrix-zeroes/
