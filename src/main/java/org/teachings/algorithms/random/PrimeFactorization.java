package org.teachings.algorithms.random;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();

        // Step 1: Divide by 2 until n becomes odd
        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }

        // Step 2: Try to divide by odd numbers, starting from 3
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Step 3: If n is a prime greater than 2
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args) {
//        long number = 9223372036854775807L;
        long number = 1317624576693539401L;
        List<Long> factors = primeFactors(number);
        System.out.println("Prime factors of " + number + " are: " + factors);
    }
}
