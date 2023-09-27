package org.teachings.gpt.random;

public class PalindromeNumber {

    public static void main(String[] args) {
        new PalindromeNumber().start();
    }

    private void start() {
        int input = 2341432;
        System.out.printf("Input [%s] is palindrome [%s].", input, isPalindrome(input));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return (x == reversed || x == reversed / 10);
    }
}
