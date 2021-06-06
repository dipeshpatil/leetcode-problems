package String.Easy;

import java.util.Arrays;

public class CheckIfWordEqualsSummationOfTwoWords {
    public static void main(String[] args) {
        CheckIfWordEqualsSummationOfTwoWords o = new CheckIfWordEqualsSummationOfTwoWords();

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.isSumEqual("acb", "cba", "cdb"),
                                o.isSumEqual("aaa", "a", "aab"),
                                o.isSumEqual("aaa", "a", "aaaa")
                        }
                )
        );
        //  [true, false, true]
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder A = new StringBuilder(), B = new StringBuilder(), T = new StringBuilder();

        for (int i = 0; i < firstWord.length(); i++)
            A.append(firstWord.charAt(i) - 97);

        for (int i = 0; i < secondWord.length(); i++)
            B.append(secondWord.charAt(i) - 97);

        for (int i = 0; i < targetWord.length(); i++)
            T.append(targetWord.charAt(i) - 97);

        return Integer.parseInt(A.toString()) + Integer.parseInt(B.toString()) == Integer.parseInt(T.toString());
    }
}

// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
