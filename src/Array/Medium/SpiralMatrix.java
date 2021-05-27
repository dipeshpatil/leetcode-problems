package Array.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] mat2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        SpiralMatrix o = new SpiralMatrix();
        System.out.println(o.spiralOrder(mat1));
        System.out.println(o.spiralOrder(mat2));

        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        // [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int layers = Math.floorDiv(matrix.length, 2);
        spiralOrderHelper(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, layers, list);
        return list;
    }

    private void spiralOrderHelper(int[][] matrix, int left, int right, int top, int bottom, int layers, List<Integer> list) {
        for (int i = left; i <= right && top <= bottom; i++)
            list.add(matrix[top][i]);

        for (int i = top + 1; i <= bottom && left <= right; i++)
            list.add(matrix[i][right]);

        for (int i = right - 1; i >= left && top < bottom; i--)
            list.add(matrix[bottom][i]);

        for (int i = bottom - 1; i >= top + 1 && left < right; i--)
            list.add(matrix[i][left]);

        if (layers > 0)
            spiralOrderHelper(matrix, left + 1, right - 1, top + 1, bottom - 1, --layers, list);
    }
}

// https://leetcode.com/problems/spiral-matrix/
