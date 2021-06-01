package Array.Medium;

import java.util.Arrays;

public class SearchInA2DMatrix {
    public static void main(String[] args) {
        SearchInA2DMatrix o = new SearchInA2DMatrix();

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.searchMatrix(
                                        new int[][]{
                                                {1, 3, 5, 7},
                                                {10, 11, 16, 20},
                                                {23, 30, 34, 60}
                                        }, 3
                                ),
                                o.searchMatrix(
                                        new int[][]{
                                                {1, 3, 5, 7},
                                                {10, 11, 16, 20},
                                                {23, 30, 34, 60}
                                        }, 13
                                )
                        }
                )
        );
        // [true, false]
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;

        for (int[] row : matrix)
            found = found || binarySearch(row, target);

        return found;
    }

    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (row[mid] == target)
                return true;
            else if (target > row[mid])
                low = mid + 1;
            else if (target < row[mid])
                high = mid - 1;
        }

        return false;
    }
}

// https://leetcode.com/problems/search-a-2d-matrix/
