package org.teachings.gpt.random;

public class TortoiseAndHare {

    public static void main(String[] args) {
        new TortoiseAndHare().start();
    }

    public void start() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // creating the loop

        Node loopNode = findCycleStartNode(head);
        System.out.println("Loop found at node: " + (loopNode != null ? loopNode.data : "no loop"));
    }

    public static Node findCycleStartNode(Node head) {
        Node tortoise = head;
        Node hare = head;
        boolean hasLoop = false;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                hasLoop = true;
                break;
            }
        }

        if (hasLoop) {
            tortoise = head; // reset
            while (tortoise != hare) {
                tortoise = tortoise.next;
                hare = hare.next;
            }
            return tortoise; // loop start point
        }
        return null;  // No loop
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
