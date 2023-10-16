package org.teachings.gpt.leetcode.linkedLists;

import org.teachings.gpt.leetcode.linkedLists.common.Node;

import static org.teachings.gpt.leetcode.linkedLists.common.ListUtils.createListOf;
import static org.teachings.gpt.leetcode.linkedLists.common.ListUtils.merge;

public class MergeTwoSortedLists {

    /*
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by
     * splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     *
     * Example
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     */

    public static void main(String[] args) {
        new MergeTwoSortedLists().start();
    }

    private void start() {
        Node firstHead = createListOf(new int[]{1, 2, 4}, 0);
        Node secondHead = createListOf(new int[]{1, 1, 1, 3, 4}, 0);
        System.out.println(merge(firstHead, secondHead));
    }
}
