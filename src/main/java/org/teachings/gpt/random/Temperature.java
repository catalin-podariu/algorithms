package org.teachings.gpt.random;

public class Temperature {

    /*
     * You're given an array of floating point numbers representing temperatures,
     * and you need to return the one closest to zero.
     *
     * Understanding Edge Cases and Constraints:
     * The array is never null but can be empty.
     * When the array is empty, we return 0.
     *
     * Temperatures range from -273 (absolute zero) to 5526 (presumably in Celsius).
     * If two numbers are equidistant from zero, the positive number is considered closer.
     */
    public static void main(String[] args) {
        new Temperature().start();
    }

    private void start() {
        double[] temperatures = {-10, 4, 3.5, -3.7, -1.7, 6.5, 8, 7};
        System.out.println(closestToZero(temperatures)); // Expecting: -1.7
    }

    private double closestToZero(double[] input) {
        if (input.length == 0) return 0;
        if (input.length == 1) return input[0];

        double closest = Double.MAX_VALUE;

        for (double item : input) {
            if (Math.abs(item) < Math.abs(closest)
                    || (Math.abs(item) == closest && closest < item)) {
                closest = item;
            }
        }
        return closest;
    }
}
