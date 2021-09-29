package calculator;

public class AdvanceCac extends Calculator{
    @Override
    public String listOperations() {
        return super.listOperations() + ", pow, %";
    }

    @Override
    public double calculateOperation2() {
        switch (operation){
            case "pow":
                return Math.pow(a, b);
            case "%":
                return a % b;
        }
        return super.calculateOperation2();
    }
}
