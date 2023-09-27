package org.teachings.gpt.random;

import java.util.LinkedList;
import java.util.List;

public class KidsWithCandy {

    public static void main(String[] args) {
        new KidsWithCandy().start();
    }

    private void start() {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(
                listToString(
                        kidsWithCandies(candies, extraCandies)
                )
        );
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new LinkedList<>();
        int largest = 0;

        for (int item : candies) {
            if (item > largest) {
                largest = item;
            }

        }
        for (int item : candies) {
            if (item + extraCandies >= largest) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }

    public static String listToString(List<Boolean> list) {
        if (list == null)
            return "null";
        int max = list.size() - 1;
        if (max == -1)
            return "[]";

        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; ; i++) {
            builder.append(list.get(i));
            if (i == max)
                return builder.append(']').toString();
            builder.append(", ");
        }
    }
}
