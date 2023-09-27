package org.teachings.gpt.structured.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        new ValidAnagram().start();
    }

    private void start() {
        String s = "Chicken lips are fun to eat!";
        String t = "Chicken are lips fun to eat!";
        boolean isAnagram = isAnagram_HashMap(s, t);

        if (isAnagram) {
            System.out.printf("[%s] is an anagram of [%s]", s, t);
        }
        else {
            System.out.println("No anagram between these two..");
        }
    }

    private boolean isAnagram_SimpleArrays(String s, String t) {
        if (s.length() != t.length() || s.isEmpty()) {
            return false;
        }

        int[] sCount = new int[256];
        int[] tCount = new int[256];

        for (char c : s.toCharArray()) {
            sCount[c]++;
        }

        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        System.out.println(Arrays.toString(sCount));
        System.out.println(Arrays.toString(tCount));

        return Arrays.equals(sCount, tCount);
    }

    private boolean isAnagram_HashMap(String s, String t) {
        if (s.length() != t.length() || s.isEmpty()) {
            return false;
        }

        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        System.out.println(Arrays.toString(sCount.keySet().toArray(new Character[0])));
        System.out.println(Arrays.toString(tCount.keySet().toArray(new Character[0])));

        return sCount.equals(tCount);
    }
}
