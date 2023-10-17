package org.teachings.algorithms.leetcode.twoPointers;

public class ValidPalindrome {

    /*
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
     * and removing all non-alphanumeric characters, it reads the same forward and backward.
     * Alphanumeric characters include letters and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     */
    public static void main(String[] args) {
        new ValidPalindrome().start();
    }

    private void start() {
        String input = "A man, a plan, a canal: Panama";
        System.out.printf("\n[%s] is palindrome [%s]\n", input, isPalindrome(input));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        char[] input = s.toLowerCase().toCharArray();
        int i = 0;
        int j = input.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(input[i])) i++;
            while (i < j && !Character.isLetterOrDigit(input[j])) j--;
            if (input[i] != input[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
