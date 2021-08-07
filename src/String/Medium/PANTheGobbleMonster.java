package String.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class PANTheGobbleMonster {
    public static void main(String[] args) {
        PANTheGobbleMonster o = new PANTheGobbleMonster();
        HashSet<Character> charSet = new HashSet<>();

        charSet.add('P');
        charSet.add('A');
        charSet.add('N');
        charSet.add('p');
        charSet.add('a');
        charSet.add('n');

        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.pan("PANNnnap", charSet),
                                o.pan("NPpn", charSet),
                                o.pan("NP", charSet),
                                o.pan("pP", charSet),
                                o.pan("PANnap", charSet),
                        }
                )
        );

        //  [Feed, Feed, Throw, Throw, Feed]
    }

    public String pan(String input, HashSet<Character> charSet) {
        int N = input.length();
        int i = 0, j = N - 1;

        if (N % 2 == 1)
            return "Throw";

        while (i < j) {
            Character c1 = input.charAt(i);
            Character c2 = input.charAt(j);

            if (charSet.contains(c1) && charSet.contains(c2)) {
                if (!Character.isUpperCase(c1) || !Character.isLowerCase(c2) || c1 != Character.toUpperCase(c2))
                    return "Throw";
            } else
                return "Throw";

            i++;
            j--;
        }

        return "Feed";
    }
}
