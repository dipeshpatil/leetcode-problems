package String.Hard;

import java.util.Arrays;
import java.util.regex.*;

public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber o = new ValidNumber();

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.isNumber("-123.456e789"),
                                o.isNumber("-90E3"),
                                o.isNumber("2e10"),
                                o.isNumber("95a54e53"),
                                o.isNumber("--6"),
                                o.isNumber("abc")
                        }
                )
        );

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.isNumberRegex("99e2.5"),
                                o.isNumberRegex("-+3"),
                                o.isNumberRegex("e3"),
                                o.isNumberRegex("4."),
                                o.isNumberRegex("4."),
                                o.isNumberRegex("-0.1")
                        }
                )
        );

        // [true, true, true, false, false, false]
        // [false, false, false, true, true, true]
    }

    public boolean isNumber(String s) {
        boolean digitSeen = false, eSeen = false, dotSeen = false;
        int countPM = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch))
                digitSeen = true;
            else if (ch == '+' || ch == '-') {
                if (countPM == 2)
                    return false;

                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;

                if (i == s.length() - 1)
                    return false;
                countPM++;
            } else if (ch == '.') {
                if (eSeen || dotSeen)
                    return false;

                if (i == s.length() - 1 && !digitSeen)
                    return false;

                dotSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !digitSeen || i == s.length() - 1)
                    return false;

                eSeen = true;
            } else
                return false;
        }

        return true;
    }

    public boolean isNumberRegex(String s) {
        String regex = "^[+-]?(((\\d+\\.\\d*)|(\\.\\d+))|\\d+)([eE][+-]?\\d+)?$";
        return Pattern.matches(regex, s);
    }
}

// https://leetcode.com/problems/valid-number/
