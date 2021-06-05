package Array.Easy;

import java.util.Arrays;

public class XOROperationInAnArray {
    public static void main(String[] args) {
        XOROperationInAnArray o = new XOROperationInAnArray();

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.xorOperation(5, 0),
                                o.xorOperation(4, 3),
                                o.xorOperation(1, 7),
                                o.xorOperation(10, 5),
                        }
                )
        );
        //  [8, 8, 7, 2]
    }

    public int xorOperation(int n, int start) {
        int sum = start;

        for (int i = 1; i < n; i++)
            sum ^= start + 2 * i;

        return sum;
    }
}

// https://leetcode.com/problems/xor-operation-in-an-array/
