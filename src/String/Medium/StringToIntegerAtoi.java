package String.Medium;

import java.util.Arrays;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        StringToIntegerAtoi o = new StringToIntegerAtoi();

        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.myAtoi("42"),
                                o.myAtoi("   -42"),
                                o.myAtoi("4193 with words"),
                                o.myAtoi("words and 987"),
                                o.myAtoi("-91283472332"),
                                o.myAtoi(" ")
                        }
                )
        );
        //  [42, -42, 4193, 0, -2147483648, 0]
    }

    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;

        if (s.length() == 0)
            return 0;

        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        if (index == s.length())
            return 0;

        if (s.charAt(index) == '+' || s.charAt(index) == '-')
            sign = s.charAt(index++) == '-' ? -1 : 1;

        while (index < s.length()) {
            int digit = s.charAt(index) - '0';

            if (digit < 0 || digit > 9)
                break;

            boolean checkOverflowOrUnderflowCondition = total > Integer.MAX_VALUE / 10
                    || total == Integer.MAX_VALUE / 10
                    && digit > Integer.MAX_VALUE % 10;

            if (checkOverflowOrUnderflowCondition)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}

// https://leetcode.com/problems/string-to-integer-atoi/
