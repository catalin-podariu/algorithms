package org.teachings.algorithms.leetcode.stack;

import java.util.Stack;

public class ValidParentheses {

    /*
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     *
     * An input string is valid if:
     * - Open brackets must be closed by the same type of brackets.
     * - Open brackets must be closed in the correct order.
     * - Every close bracket has a corresponding open bracket of the same type.
     *
     * Example
     * Input: s = "()[]{}"
     * Output: true
     */
    public static void main(String[] args) {
        new ValidParentheses().start();
    }

    private void start() {
        String input = "{}[]()";
        System.out.printf("Is valid parentheses for - %s -- %s\n", input, isValid(input));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topBracket = stack.pop();

                if (c == ')' && topBracket != '(') {
                    return false;
                } else if (c == '}' && topBracket != '{') {
                    return false;
                } else if (c == ']' && topBracket != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
