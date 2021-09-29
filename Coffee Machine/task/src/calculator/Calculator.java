package calculator;

public class Calculator {
    protected Double a;
    protected Double b;
    protected Double c;
    protected String operation;

    public void setA(Double a) {
        this.a = a;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double calculateOperation2() {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
    public double calculateOperation3() {
        switch (operation) {
            case "+":
                return a + b + c;
            case "-":
                return a - b - c;
            case "*":
                return a * b * c;
            case "/":
                return a / b / c;
        }
        return 0;
    }

    public String listOperations() {
        return "+, - , *, /";
    }
}
