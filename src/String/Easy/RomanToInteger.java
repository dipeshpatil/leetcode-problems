package String.Easy;

import java.util.Arrays;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger o = new RomanToInteger();
        System.out.println(
                Arrays.toString(
                        new int[]{
                                o.romanToInt("III"),
                                o.romanToInt("IV"),
                                o.romanToInt("IX"),
                                o.romanToInt("LVIII"),
                                o.romanToInt("MCMXCIV")
                        }
                )
        );
        // [3, 4, 9, 58, 1994]
    }

    public int romanToInt(String s) {
        int nextI, currV, nextV, sum = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            currV = getVal(chars[i]);
            nextI = i + 1;

            if (nextI == chars.length) {
                sum += currV;
                break;
            }
            nextV = getVal(chars[nextI]);
            if (nextV > currV) {
                sum += nextV - currV;
                i++;
            } else {
                sum += currV;
            }
        }

        return sum;
    }

    private int getVal(char x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

// https://leetcode.com/problems/roman-to-integer/
