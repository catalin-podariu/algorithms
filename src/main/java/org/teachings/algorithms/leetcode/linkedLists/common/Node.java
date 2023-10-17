package org.teachings.algorithms.leetcode.linkedLists.common;

public class Node {

    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        buildString(builder, "");
        return builder.toString();
    }

    private void buildString(StringBuilder builder, String prefix) {
        builder.append(prefix)
                .append("└── ")
                .append(value)
                .append("\n");

        if (next != null) {
            next.buildString(builder, prefix + ("\t"));
        }
    }
}
