package String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams o = new GroupAnagrams();

        System.out.println(
                o.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})
                        .toString()
        );

        // [[eat, tea, ate], [bat], [tan, nat]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);
            List<String> group = groups.getOrDefault(anagram, new ArrayList<>());
            group.add(s);
            groups.put(anagram, group);
        }

        return List.copyOf(groups.values());
    }
}

// https://leetcode.com/problems/group-anagrams/
