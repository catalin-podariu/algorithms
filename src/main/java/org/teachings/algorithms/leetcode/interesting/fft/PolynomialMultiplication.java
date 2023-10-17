package org.teachings.algorithms.leetcode.interesting.fft;

public class PolynomialMultiplication {

    // Assume FFT class is the same as before

    public static Complex[] multiplyPolynomials(Complex[] a, Complex[] b) {
        int n = 1;
        // Determine the smallest power of 2 greater than or equal to a.length + b.length - 1
        while (n < a.length + b.length - 1) {
            n *= 2;
        }

        // Step 1: Padding zeros
        Complex[] newA = new Complex[n];
        Complex[] newB = new Complex[n];
        for (int i = 0; i < n; i++) {
            newA[i] = (i < a.length) ? a[i] : new Complex(0, 0);
            newB[i] = (i < b.length) ? b[i] : new Complex(0, 0);
        }

        // Step 2: Compute FFT for padded polynomials
        Complex[] A = FFT.fft(newA);
        Complex[] B = FFT.fft(newB);

        // Step 3: Element-wise multiplication
        Complex[] C = new Complex[n];
        for (int i = 0; i < n; i++) {
            C[i] = A[i].times(B[i]);
        }

        // Step 4: Inverse FFT
        Complex[] c = FFT.ifft(C);  // Assuming you've implemented inverse FFT
        // Usually, you'd also round to the nearest integer here if your coefficients are integers

        return c;
    }
}
