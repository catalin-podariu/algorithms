package org.teachings.algorithms.leetcode.linkedLists;

import org.teachings.algorithms.leetcode.linkedLists.common.ListUtils;
import org.teachings.algorithms.leetcode.linkedLists.common.Node;

public class AddTwoNumbers {

    /*
     * You are given two non-empty linked lists representing two non-negative integers. The digits
     * are stored in reverse order and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807
     */
    public static void main(String[] args) {
        new AddTwoNumbers().start();
    }

    private void start() {
        Node list1 = ListUtils.createListOf(new int[]{2, 4, 3}, 0);
        Node list2 = ListUtils.createListOf(new int[]{5, 6, 4}, 0);
        System.out.println(addTwoNumbers(list1, list2));
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node dummy = new Node(0);
        Node current = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;

            current.next = new Node(sum);
            current = current.next;
        }
        return dummy.next;
    }
}
