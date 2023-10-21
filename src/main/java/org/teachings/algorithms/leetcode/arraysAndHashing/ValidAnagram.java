package org.teachings.algorithms.leetcode.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    /*
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word
     * or phrase, typically using all the original letters exactly once.
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */
    public static void main(String[] args) {
        new ValidAnagram().start();
    }

    private void start() {
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = isAnagram_HashMap(s, t);

        if (isAnagram) {
            System.out.printf("[%s] is an anagram of [%s]", s, t);
        } else {
            System.out.println("No anagram between these two..");
        }
    }

    private boolean isAnagram_HashMap(String s, String t) {
        if (s.length() != t.length() || s.isEmpty()) {
            return false;
        }

        HashMap<Character, Integer> sFreq = new HashMap<>();
        HashMap<Character, Integer> tFreq = new HashMap<>();

        for (char c : s.toCharArray()) {
            sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        return sFreq.equals(tFreq);
    }

    private boolean isAnagram_SimpleArrays(String s, String t) {
        if (s.length() != t.length() || s.isEmpty()) {
            return false;
        }

        int[] sFreq = new int[256];
        int[] tFreq = new int[256];

        for (char c : s.toCharArray()) {
            sFreq[c]++;
        }
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }
        return Arrays.equals(sFreq, tFreq);
    }
}
