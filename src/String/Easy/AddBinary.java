package String.Easy;

import java.util.Arrays;

public class AddBinary {
    public static void main(String[] args) {
        AddBinary o = new AddBinary();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.addBinary("11", "1"),
                                o.addBinary("1010", "1011"),
                                o.addBinary("10101100110", "001100101"),
                        }
                )
        );
        // [100, 10101, 10111001011]
    }

    public String addBinary(String a, String b) {
        int p1 = a.length() - 1, p2 = b.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();

        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;

            if (p2 >= 0)
                sum += b.charAt(p2--) - '0';
            if (p1 >= 0)
                sum += a.charAt(p1--) - '0';

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0)
            result.append(carry);

        return result.reverse().toString();
    }
}

// https://leetcode.com/problems/add-binary/
