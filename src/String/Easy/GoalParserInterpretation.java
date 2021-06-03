package String.Easy;

import java.util.Arrays;

public class GoalParserInterpretation {
    public static void main(String[] args) {
        GoalParserInterpretation o = new GoalParserInterpretation();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.interpret("G()(al)"),
                                o.interpret("G()()()()(al)"),
                                o.interpret("(al)G(al)()()G")
                        }
                )
        );
        // [Goal, Gooooal, alGalooG]
    }

    public String interpret(String command) {
        int len = command.length();
        if (len == 1)
            return command;

        int p1 = 0, p2 = 1;
        StringBuilder result = new StringBuilder();

        while (p1 < len - 1 && p2 < len) {
            char p = command.charAt(p1);
            char q = command.charAt(p2);

            if (p == 'G') {
                result.append('G');
                p1++;
                p2++;
            } else if (p == '(' && q == ')') {
                result.append('o');
                p1 += 2;
                p2 += 2;
            } else if (p == '(' && q == 'a') {
                result.append("al");
                p1 += 4;
                p2 += 4;
            }

            if (p1 >= len - 1 || p2 >= len)
                break;
        }

        if (command.charAt(len - 1) == 'G')
            result.append('G');

        return result.toString();
    }
}

// https://leetcode.com/problems/goal-parser-interpretation/
