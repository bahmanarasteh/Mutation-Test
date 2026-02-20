package remainder;

public class Remainder {

    // Computes the integer remainder of dividend / divisor
    public static int compute(int dividend, int divisor) {

        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }

        // Normalize sign to keep remainder non-negative (benchmark-friendly)
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int r = a % b;

        // Restore sign rule similar to Java: remainder follows dividend sign
        if (dividend < 0) {
            r = -r;
        }

        return r;
    }
}
