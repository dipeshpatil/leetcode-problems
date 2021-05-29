package Array.Medium;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage o = new RotateImage();

        o.rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]
    }

    public void rotate(int[][] matrix) {
        int size = matrix.length;
        // transpose
        for (int i = 0; i < size; i++)
            for (int j = i; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        // reverse rows
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - j - 1];
                matrix[i][size - j - 1] = temp;
            }

        displayMatrix(matrix);
    }

    private void displayMatrix(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}

// https://leetcode.com/problems/rotate-image/
