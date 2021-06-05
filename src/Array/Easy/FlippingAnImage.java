package Array.Easy;

import java.util.Arrays;

public class FlippingAnImage {
    public static void main(String[] args) {
        FlippingAnImage o = new FlippingAnImage();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                Arrays.deepToString(
                                        o.flipAndInvertImage(
                                                new int[][]{
                                                        {1, 1, 0},
                                                        {1, 0, 1},
                                                        {0, 0, 0}
                                                }
                                        )
                                ),
                                Arrays.deepToString(
                                        o.flipAndInvertImage(
                                                new int[][]{
                                                        {1, 1, 0, 0},
                                                        {1, 0, 0, 1},
                                                        {0, 1, 1, 1},
                                                        {1, 0, 1, 0}
                                                }
                                        )
                                )
                        }
                )
        );
        //  [[[1, 0, 0], [0, 1, 0], [1, 1, 1]], [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]]
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int low = 0, high = A.length - 1;

            while (low <= high) {
                if (A[i][low] == A[i][high]) {
                    A[i][low] = 1 - A[i][low];
                    A[i][high] = A[i][low];
                }
                low++;
                high--;
            }

        }

        return A;
    }
}

// https://leetcode.com/problems/flipping-an-image/
