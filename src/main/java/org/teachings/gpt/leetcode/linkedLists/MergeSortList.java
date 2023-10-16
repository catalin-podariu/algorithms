package org.teachings.gpt.leetcode.linkedLists;

import org.teachings.gpt.leetcode.linkedLists.common.Node;

import static org.teachings.gpt.leetcode.linkedLists.common.ListUtils.*;

public class MergeSortList {

    public static void main(String[] args) {
        new MergeSortList().start();
    }

    private void start() {
        Node head = createListOf(new int[]{1, 1, 1, 3, 4, 2,0, 7, 1, 5}, 0);
        System.out.println(mergeSort(head));
    }
}
