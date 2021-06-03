package String.Easy;

import java.util.Arrays;

public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        CheckIfTwoStringArraysAreEquivalent o = new CheckIfTwoStringArraysAreEquivalent();

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}),
                                o.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}),
                                o.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}),
                        }
                )
        );
        // [true, false, true]
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int p1 = 0, p2 = 0;
        int l1 = word1.length, l2 = word2.length;
        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();

        while (p1 < l1 || p2 < l2) {
            if (p1 < l1)
                r1.append(word1[p1++]);
            if (p2 < l2)
                r2.append(word2[p2++]);
        }

        return r1.toString().equals(r2.toString());
    }
}

// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
