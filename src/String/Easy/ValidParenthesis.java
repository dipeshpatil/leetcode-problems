package String.Easy;

import java.util.Arrays;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis o = new ValidParenthesis();
        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.isValid("()"),
                                o.isValid("()[]{}"),
                                o.isValid("(]"),
                                o.isValid("([)]"),
                                o.isValid("{[]}")
                        }
                )
        );

        // [true, true, false, false, true]
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char y;

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    y = stack.pop();
                    if (y == '{' || y == '[')
                        return false;
                    break;
                case '}':
                    y = stack.pop();
                    if (y == '(' || y == '[')
                        return false;
                    break;
                case ']':
                    y = stack.pop();
                    if (y == '(' || y == '{')
                        return false;
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
