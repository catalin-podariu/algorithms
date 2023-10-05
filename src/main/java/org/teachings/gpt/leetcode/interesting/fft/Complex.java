package org.teachings.gpt.leetcode.interesting.fft;

public class Complex {
    double re;  // the real part
    double im;  // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // Multiply with another Complex number
    public Complex times(Complex b) {
        double real = this.re * b.re - this.im * b.im;
        double imag = this.re * b.im + this.im * b.re;
        return new Complex(real, imag);
    }

    // Multiply with a scalar
    public Complex times(double scalar) {
        return new Complex(this.re * scalar, this.im * scalar);
    }

    public Complex conjugate() {
        return new Complex(re, -im);
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude
    public double abs() {
        return Math.hypot(re, im);
    }

    // return angle/phase/argument, normalized to be between -pi and pi
    public double phase() {
        return Math.atan2(im, re);
    }

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        return new Complex(re + b.re, im + b.im);
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        return new Complex(re - b.re, im - b.im);
    }
}
