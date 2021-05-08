package Array.Easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne o = new PlusOne();
        System.out.println(
                Arrays.toString(
                        new String[]{
                                Arrays.toString(o.plusOne(new int[]{9, 9, 9, 9})),
                                Arrays.toString(o.plusOne(new int[]{1, 2, 3, 4})),
                                Arrays.toString(o.plusOne(new int[]{4, 5, 7, 1}))
                        }
                )
        );

        // [[1, 0, 0, 0, 0], [1, 2, 3, 5], [4, 5, 7, 2]]
    }

    public int[] plusOne(int[] digits) {
        int size = digits.length;
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i] += 1;
                break;
            }
        }

        if (digits[0] == 0) {
            int[] newDigits = new int[size + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++)
                newDigits[i + 1] = digits[i];
            return newDigits;
        }

        return digits;
    }
}

/*
    https://leetcode.com/problems/plus-one/
*/
