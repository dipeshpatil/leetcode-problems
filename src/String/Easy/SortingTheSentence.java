package String.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class SortingTheSentence {
    public static void main(String[] args) {
        SortingTheSentence o = new SortingTheSentence();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.sortSentence("is2 sentence4 This1 a3"),
                                o.sortSentence("Myself2 Me1 I4 and3"),
                                o.sortSentence("quick2 dog9 brown3 fox4 over6 The1 jumps5 lazy8 the7"),
                        }
                )
        );
        // [This is a sentence, Me Myself and I, The quick brown fox jumps over the lazy dog]
    }

    public String sortSentence(String s) {
        int p1 = 0, p2 = 0, count = 0;
        int len = s.length();

        if (len == 2)
            return s.substring(0,len - 1);

        HashMap<Character, String> map = new HashMap<>();
        StringBuilder parsed = new StringBuilder();

        while (p1 < len && p2 < len) {
            char p = s.charAt(p2);

            while (!Character.isDigit(p))
                p = s.charAt(p2++);

            parsed = new StringBuilder(s.substring(p1, p2 - 1));
            map.put(s.charAt(p2 - 1), parsed.toString());

            count++;
            parsed = new StringBuilder();
            p1 = p2 + 1;
        }

        for (int i = 0; i < count; i++)
            if (i == count - 1)
                parsed.append(map.get((char) ((i + 1) + '0')));
            else
                parsed.append(map.get((char) ((i + 1) + '0'))).append(" ");

        return parsed.toString();
    }
}

// https://leetcode.com/problems/sorting-the-sentence/
