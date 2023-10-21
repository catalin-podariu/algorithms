package org.teachings.algorithms.leetcode.linkedLists.common;

public class ListUtils {

    // Singly linked list format is [Value | Next] -> [Value | Next] -> ... -> [Value | Next]
    // Doubly linked list format is [Prev | Value | Next] <-> [Prev | Value | Next] <-> ... <-> [Prev | Value | Next]

    // kept method like this to easily visualise the loop
    public static Node createListWithLoop() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head.next.next.next.next.next = head.next.next; // creating the loop

        return head;
    }

    public static Node createListOf(int[] values, int startingPoint) {
        if (values == null || startingPoint >= values.length) return null;
        Node newNode = new Node(values[startingPoint]);
        newNode.next = createListOf(values, startingPoint + 1);
        return newNode;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        // Disconnect the two halves
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    public static Node getMiddle(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        // Divide the list into two halves using slow/fast pointer technique
        while (fast.next != null
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node headOfList1, Node headOfList2) {
        Node dummy = new Node(0);
        Node current = dummy;

        // While neither of the lists is empty
        while (headOfList1 != null && headOfList2 != null) {
            if (headOfList1.value < headOfList2.value) {
                current.next = headOfList1;
                headOfList1 = headOfList1.next; // basically i++
            } else {
                current.next = headOfList2;
                headOfList2 = headOfList2.next; // basically i++
            }
            // Move the current pointer to the latest added node
            current = current.next;
        }

        // If either list still has nodes, append it to the merged list
        if (headOfList1 != null) current.next = headOfList1;
        if (headOfList2 != null) current.next = headOfList2;

        return dummy.next;
    }

    public static boolean hasLoop(Node head) {
        Node slow = head;
        Node fast = head;
        boolean hasLoop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        return hasLoop;
    }
}
