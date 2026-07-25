class PiCalculator {
    private double pi; 

    protected void calculate() { 
        pi = Math.PI;
    }

    public double getPi() { 
        if (pi == 0) calculate();
        return pi;
    }
}

public class Main {
    public static void main(String[] args) {
        PiCalculator p = new PiCalculator();
        System.out.println("Pi value: " + p.getPi()); 
    }
}
