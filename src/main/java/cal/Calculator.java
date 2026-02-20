package cal;

public class Calculator {

    public double cal(double a, double b, char operator) {
        double result;
        switch (operator) {
            case '-':
                result = b - a;
                break;
            case '+':
                result = b + a;
                break;
            case '*':
                result = b * a;
                break;
            case '/':
                result = b / a;
                System.out.println(result);
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
