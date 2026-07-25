interface Shape {
    double calculateArea(); 
}
class Circle implements Shape {
    private double radius;  

    public Circle(double radius) { 
        this.radius = radius;
    }

    protected double getRadius() { 
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        System.out.println("Circle Area: " + circle.calculateArea());
    }
}
