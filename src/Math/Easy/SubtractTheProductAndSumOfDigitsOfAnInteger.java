package Math.Easy;

import java.util.Arrays;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        SubtractTheProductAndSumOfDigitsOfAnInteger o = new SubtractTheProductAndSumOfDigitsOfAnInteger();

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.subtractProductAndSum(234),
                                o.subtractProductAndSum(4421)
                        }
                )
        );
        // [15, 21]
    }

    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit;
            product *= digit;
        }

        return product - sum;
    }
}

// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
