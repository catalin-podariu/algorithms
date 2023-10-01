package org.teachings.gpt.leetcode.arraysAndHashing;

import java.util.*;

public class GroupAnagrams {

    /*
     * Given an array of strings strs, group the anagrams together.
     * You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a
     * different word or phrase, typically using all the original letters exactly once.
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static void main(String[] args) {
        new GroupAnagrams().start();
    }

    private void start() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
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
