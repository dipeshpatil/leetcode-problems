package String.Easy;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString o = new ReverseString();
        char[] seq = new char[]{'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
        o.reverseString(seq);

        System.out.println(
                Arrays.toString(seq)
        );
        // [d, l, r, o, w, o, l, l, e, h]
    }

    public void reverseString(char[] s) {
        int first = 0, last = s.length - 1;
        while (first < last)
            exch(s, first++, last--);
    }

    private void exch(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// https://leetcode.com/problems/reverse-string/
