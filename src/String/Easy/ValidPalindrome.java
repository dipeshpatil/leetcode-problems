package String.Easy;

import java.util.Arrays;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome o = new ValidPalindrome();
        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.isPalindrome("A man, a plan, a canal: Panama"),
                                o.isPalindrome("race a car")
                        }
                )
        );
    }

    public boolean isPalindrome(String s) {
        int first = 0, last = s.length() - 1;
        char fc, lc;

        while (first < last) {
            while (isSpecial(s.charAt(first)) && first < last) first++;
            while (isSpecial(s.charAt(last)) && first < last) last--;

            fc = s.charAt(first);
            lc = s.charAt(last);

            if (Character.toLowerCase(fc) != Character.toLowerCase(lc))
                return false;

            first++;
            last--;
        }

        return true;
    }

    private boolean isSpecial(char x) {
        return !Character.isAlphabetic(x)
                && !Character.isDigit(x)
                || Character.isSpaceChar(x);
    }
}

// https://leetcode.com/problems/valid-palindrome/
