package org.teachings.gpt.random;

import java.util.HashMap;

public class DuplicateCharacters {

    public static void main(String[] args) {
        new DuplicateCharacters().start();
    }

    public void start() {
        String input = "abbacd";
        char result = findFirst(input);
        if (result != 0) {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("All characters repeat.");
        }
    }

    public char findFirst(String input) {
        if (input == null) {
            return 0;
        }

        HashMap<Character, Integer> charCounter = new HashMap<>();

        for (char c : input.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }

        for (char c : input.toCharArray()) {
            if (charCounter.get(c) == 1) {
                return c;
            }
        }
        return 0;
    }
}
