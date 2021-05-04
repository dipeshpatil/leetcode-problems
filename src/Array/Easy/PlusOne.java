package Array.Easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne o = new PlusOne();
        System.out.println(
                Arrays.toString(
                        o.plusOne(new int[]{9, 9, 9, 9})
                )
        );
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
    Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.
 */