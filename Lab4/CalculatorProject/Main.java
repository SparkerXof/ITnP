package CalculatorProject;

import ExceptionLogger.ExceptionLogger;

public class Main {
    public static void main(String[] args) {
        double num1;
        double num2;
        String[] line = args[0].split(" ");
        try {
            num1 = Double.parseDouble(line[0]);
            num2 = Double.parseDouble(line[2]);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number");
            ExceptionLogger.log(e);
            return;
        }

        try {
            double result = Calculator.calc(num1, line[1], num2);
            System.out.println(num1 + " " + line[1] + " " + num2 + " = " + result);
        }
        catch (CustomUnsupportedOperationException e) {
            System.out.println("Wrong operator: " + e.getOperator());
            ExceptionLogger.log(e);
        }
    }
}
