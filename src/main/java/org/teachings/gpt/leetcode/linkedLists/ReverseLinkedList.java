package org.teachings.gpt.leetcode.linkedLists;

import org.teachings.gpt.leetcode.linkedLists.common.Node;

import static org.teachings.gpt.leetcode.linkedLists.common.ListUtils.createListOf;

public class ReverseLinkedList {

    /*
     * Given the head of a singly linked list, reverse the list and return the reversed list.
     */
    public static void main(String[] args) {
        new ReverseLinkedList().start();
    }

    private void start() {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7};

        Node first = createListOf(values, 0);
        System.out.println(first);
        Node firstReversed = reverseList_Iteratively(first);
        System.out.println(firstReversed);

        Node second = createListOf(values, 0);
        System.out.println(second);
        Node secondReversed = reverseList_Recursively(second);
        System.out.println(secondReversed);
    }

    private Node reverseList_Iteratively(Node head) {
        if (head == null) return null;
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // store the next node
            current.next = previous; // reverse the current node's pointer
            previous = current; // move previous one step forward
            current = next; // move current one step forward
        }
        head = previous; // reset head to the last node in the original list
        return head;
    }

    private Node reverseList_Recursively(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = reverseList_Recursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
