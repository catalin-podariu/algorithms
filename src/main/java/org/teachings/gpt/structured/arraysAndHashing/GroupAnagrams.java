package org.teachings.gpt.structured.arraysAndHashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        new GroupAnagrams().start();
    }

    private void start() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> result = new HashMap<>();

        for (String item : strs) {
            char[] temp = item.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);

            if (!result.containsKey(sorted)) {
                result.put(sorted, new ArrayList<>());
            }
            result.get(sorted).add(item);
        }
        return new ArrayList<>(result.values());
    }

}
