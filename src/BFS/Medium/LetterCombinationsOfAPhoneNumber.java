package BFS.Medium;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber o = new LetterCombinationsOfAPhoneNumber();

        System.out.println(
                Arrays.deepToString(
                        new String[][]{
                                o.letterCombinations("23").toArray(new String[0]),
                                o.letterCombinations("56").toArray(new String[0])
                        }
                )
        );
        //  [ad, bd, cd, ae, be, ce, af, bf, cf]
        //  [jm, km, lm, jn, kn, ln, jo, ko, lo]
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        Queue<Character> digitsQueue = new LinkedList<>();
        HashMap<Character, List<Character>> phone = new HashMap<>();

        for (int i = 0; i < digits.length(); i++)
            digitsQueue.add(digits.charAt(i));

        phone.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        phone.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        phone.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        phone.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        phone.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        phone.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        phone.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        phone.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        return bfs(digitsQueue, phone);
    }

    private List<String> bfs(Queue<Character> digitsQueue, HashMap<Character, List<Character>> phone) {
        List<String> result = new LinkedList<>();
        Character currentDigit = digitsQueue.poll();
        List<Character> currentLetters = phone.get(currentDigit);

        for (Character c : currentLetters)
            result.add(String.valueOf(c));

        while (!digitsQueue.isEmpty()) {
            List<String> currentList = new ArrayList<>(result);
            currentDigit = digitsQueue.poll();
            currentLetters = phone.get(currentDigit);
            List<String> newResult = new ArrayList<>();

            for (Character x : currentLetters) {
                for (String y : currentList) {
                    String newString = y + x;
                    newResult.add(newString);
                }
            }

            result = new ArrayList<>(newResult);
        }

        return result;
    }
}

//  https://leetcode.com/problems/letter-combinations-of-a-phone-number/
