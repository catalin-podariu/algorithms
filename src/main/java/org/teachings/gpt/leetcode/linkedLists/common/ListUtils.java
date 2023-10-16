package org.teachings.gpt.leetcode.linkedLists.common;

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

    public static Node createListOf(int[] values, int index) {
        // base case
        if (values == null || index >= values.length) return null;

        // Create a new node with the current array value
        Node newNode = new Node(values[index]);

        // Recursively create the rest of the list
        newNode.next = createListOf(values, index + 1);
        return newNode;
    }

    public static Node merge(Node headOfList1, Node headOfList2) {
        Node dummy = new Node(0);
        Node current = dummy;

        // While neither of the lists is empty
        while (headOfList1 != null && headOfList2 != null) {
            if (headOfList1.value < headOfList2.value) {
                current.next = headOfList1;
                headOfList1 = headOfList1.next;
            } else {
                current.next = headOfList2;
                headOfList2 = headOfList2.next;
            }
            // Move the current pointer to the latest added node
            current = current.next;
        }

        // If either list still has nodes, append it to the merged list
        if (headOfList1 != null) current.next = headOfList1;
        if (headOfList2 != null) current.next = headOfList2;

        return dummy.next;
    }
}
