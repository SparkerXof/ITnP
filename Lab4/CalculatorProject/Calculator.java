package CalculatorProject;

public class Calculator {
    public static double calc(double num1, String operator, double num2) throws CustomUnsupportedOperationException {
        if (operator.length() > 1) {
            throw new CustomUnsupportedOperationException("Operator \"" + operator + "\" is not allowed", operator);
        }
        switch (operator.toCharArray()[0]) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new CustomUnsupportedOperationException("Operator \"" + operator + "\" is not allowed", operator);
        }
    }
}
