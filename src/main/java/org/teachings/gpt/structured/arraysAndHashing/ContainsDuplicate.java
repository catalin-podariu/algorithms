package org.teachings.gpt.structured.arraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        new ContainsDuplicate().start();
    }

    private void start() {
        int[] input = {1, 2, 3, 1};

        if (containsDuplicate(input)) {
            System.out.println("Duplicate found.");
        } else {
            System.out.println("Duplicate NOT found.");
        }
    }

    private boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
