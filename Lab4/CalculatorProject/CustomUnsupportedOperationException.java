package CalculatorProject;

public class CustomUnsupportedOperationException extends UnsupportedOperationException {
    private String operator;

    public CustomUnsupportedOperationException(String name, String operator) {
        super(name);
        this.operator = operator;
    }

    public String getOperator() { return operator; }
}
