package String.Medium;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring o = new LongestPalindromicSubstring();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.longestPalindrome("babad"),
                                o.longestPalindrome("cbbd"),
                                o.longestPalindrome("a"),
                                o.longestPalindrome("ac")
                        }
                )
        );
        //  [aba, bb, a, c]
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);
            int len = Math.max(even, odd);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}

//  https://leetcode.com/problems/longest-palindromic-substring/
