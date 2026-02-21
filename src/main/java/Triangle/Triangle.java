public class Triangle {
    public static int classify(int a, int b, int c) {
        int train;
        if (a <= 0 || b <= 0 || c <= 0)
            return 0;
        train = 0;
        if (a == b)
            train = train + 1;
        if (a == c)
            train = train + 2;
        if (b == c)
            train = train + 3;
        if (train == 0)
            if (a + b < c || a + c < b || b + c < a)
                return 0;
            else
                return 1;
        if (train > 3)
            return 3;
        if (train == 1 && a + b > c)
            return 2;
        else if (train == 2 && a + c > b)
            return 2;
        else if (train == 3 && b + c > a)
            return 2;
        return 0;
    }
}
