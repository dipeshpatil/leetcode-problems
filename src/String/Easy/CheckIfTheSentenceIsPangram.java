package String.Easy;

import java.util.Arrays;

public class CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {
        CheckIfTheSentenceIsPangram o = new CheckIfTheSentenceIsPangram();

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"),
                                o.checkIfPangram("leetcode"),
                        }
                )
        );
        // [true, false]
    }

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26)
            return false;

        int[] lettersArray = new int[26];

        for (int i = 0; i < sentence.length(); i++)
            lettersArray[sentence.charAt(i) - 97] = 1;

        for (int i = 0; i < 26; i++)
            if (lettersArray[i] == 0)
                return false;

        return true;
    }
}

// https://leetcode.com/problems/check-if-the-sentence-is-pangram/
