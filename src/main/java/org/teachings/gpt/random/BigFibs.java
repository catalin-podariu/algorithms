package org.teachings.gpt.random;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BigFibs {

    public static void main(String[] args) throws IOException {
//        new BigFibs().start();
        new BigFibs().binet();
    }

    private void start() {
        Map<BigInteger, BigInteger> memo = new HashMap<>();
        memo.put(BigInteger.ZERO, BigInteger.ZERO);
        memo.put(BigInteger.ONE, BigInteger.ONE);

        long dibSTART = System.currentTimeMillis();
        dib(BigInteger.valueOf(7_150), memo);
        long dibEND = System.currentTimeMillis();
        System.out.println("Calculation took " + (dibEND - dibSTART) + " milliseconds");

        try {
            writeToFile(memo);
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private void binet() throws IOException {
        int input = 7_000_000;
        BigInteger result = fib(input);
        String filename = "Fibonacci_" + input + "'th number.txt";
        writeToFile(result, filename);
        System.out.println("The " + input + "th Fibonacci number is really big! ");
        System.out.println("Filename is: " + filename);
    }

    // Main function to compute nth Fibonacci number
    private BigInteger fib(int n) {
        if (n == 0) return BigInteger.ZERO;

        BigInteger[][] baseMatrix = {{BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}};

        BigInteger[][] resultMatrix = matrixPower(baseMatrix, n - 1);

        return resultMatrix[0][0];
    }

    // Helper function to raise a 2x2 matrix to the power of n
    private BigInteger[][] matrixPower(BigInteger[][] a, int n) {
        if (n == 1) return a;
        if (n % 2 != 0) return multiply(a, matrixPower(a, n - 1));

        BigInteger[][] halfPower = matrixPower(a, n / 2);
        return multiply(halfPower, halfPower);
    }

    // Helper function to multiply two 2x2 matrices
    private BigInteger[][] multiply(BigInteger[][] a, BigInteger[][] b) {
        BigInteger[][] result = new BigInteger[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = BigInteger.ZERO;
                for (int k = 0; k < 2; k++) {
                    result[i][j] = result[i][j].add(a[i][k].multiply(b[k][j]));
                }
            }
        }
        return result;
    }

    private BigInteger dib(BigInteger n, Map<BigInteger, BigInteger> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        BigInteger nMinusOne = n.subtract(BigInteger.ONE);
        BigInteger nMinusTwo = n.subtract(BigInteger.TWO);
        BigInteger result = dib(nMinusOne, memo).add(dib(nMinusTwo, memo));
        memo.put(n, result);
        return result;
    }

    private void writeToFile(Map<BigInteger, BigInteger> memo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("FibonacciNumbers.txt"))) {
            for (Map.Entry<BigInteger, BigInteger> entry : memo.entrySet()) {
                writer.write("[" + entry.getKey() + "] " + entry.getValue());
                writer.newLine();
            }
        }
    }

    private void writeToFile(BigInteger output, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(String.valueOf(output));
            writer.newLine();
        }
    }
}
