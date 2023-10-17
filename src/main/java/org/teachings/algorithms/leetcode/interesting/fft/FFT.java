package org.teachings.algorithms.leetcode.interesting.fft;

public class FFT {

    public static void main(String[] args) {
        Complex[] x = {
                new Complex(1, 0),
                new Complex(0, 0),
                new Complex(0, 0),
                new Complex(2, 0),
                new Complex(1, 0),
                new Complex(0, 0),
                new Complex(0, 0),
                new Complex(2, 0)
        };
        Complex[] y = fft(x);
        for (Complex aY : y) {
            System.out.println(aY);
        }
    }

    // Compute the FFT of x[], assuming its length n is a power of 2
    public static Complex[] fft(Complex[] x) {
        int n = x.length;

        // base case
        if (n == 1) return new Complex[]{ x[0] };

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n is not a power of 2");
        }

        // FFT of even terms
        Complex[] even = new Complex[n / 2];
        for (int k = 0; k < n / 2; k++) {
            even[k] = x[2 * k];
        }
        Complex[] evenFFT = fft(even);

        // FFT of odd terms
        Complex[] odd  = even;  // reuse the array (to avoid n log n space)
        for (int k = 0; k < n / 2; k++) {
            odd[k] = x[2 * k + 1];
        }
        Complex[] oddFFT = fft(odd);

        // combine
        Complex[] result = new Complex[n];
        for (int k = 0; k < n / 2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            result[k]       = evenFFT[k].plus(wk.times(oddFFT[k]));
            result[k + n/2] = evenFFT[k].minus(wk.times(oddFFT[k]));
        }
        return result;
    }

    public static Complex[] ifft(Complex[] x) {
        int n = x.length;

        // Step 1: Conjugate the complex numbers before FFT
        for (int i = 0; i < n; i++) {
            x[i] = x[i].conjugate();
        }

        // Step 2: Compute FFT
        Complex[] y = fft(x);

        // Step 3: Conjugate the complex numbers in the result
        for (int i = 0; i < n; i++) {
            y[i] = y[i].conjugate();
        }

        // Step 4: Normalize the output
        for (int i = 0; i < n; i++) {
            y[i] = y[i].times(1.0 / n);
        }

        return y;
    }
}
