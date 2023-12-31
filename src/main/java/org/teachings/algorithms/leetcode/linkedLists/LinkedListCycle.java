package org.teachings.algorithms.leetcode.linkedLists;

import org.teachings.algorithms.leetcode.linkedLists.common.Node;

import static org.teachings.algorithms.leetcode.linkedLists.common.ListUtils.createListWithLoop;

public class LinkedListCycle {

    private Node fastPointer;

    /*
     * Floyd’s cycle finding algorithm or Hare-Tortoise algorithm is a pointer algorithm
     * that uses only two pointers, moving through the sequence at different speeds.
     * This algorithm is used to find a loop in a linked list. It uses two pointers one
     * moving twice as fast as the other one. The faster one is called the fast pointer
     * and the other one is called the slow pointer.
     *
     */
    public static void main(String[] args) {
        new LinkedListCycle().start();
    }

    public void start() {
        Node head = createListWithLoop();
        if (doesListHaveLoop(head)) {
            Node loopNode = getLoopStartingPoint(head, fastPointer);
            System.out.println("Loop found at node: " + loopNode.value);
        } else {
            System.out.println("No loop found");
        }
    }

    private boolean doesListHaveLoop(Node head) {
        Node slowPointer = head;
        fastPointer = head; // keep it 'outside' so you can divide labour

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    private Node getLoopStartingPoint(Node head, Node fastPointer) {
        Node slowPointer = head; // reset slow pointer
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}
