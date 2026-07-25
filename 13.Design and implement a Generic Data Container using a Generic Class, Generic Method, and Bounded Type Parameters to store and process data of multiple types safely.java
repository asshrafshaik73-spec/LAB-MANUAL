class DataContainer<T> {
    private T data;

    // Constructor
    public DataContainer(T data) {
        this.data = data;
    }

    // Getter
    public T getData() {
        return data;
    }

    // Setter
    public void setData(T data) {
        this.data = data;
    }

    // Display Data
    public void display() {
        System.out.println("Data: " + data);
    }

    // Generic Method
    public static <E> void printData(E value) {
        System.out.println("Generic Method Value: " + value);
    }

    // Bounded Generic Method
    public static <N extends Number> void square(N number) {
        double result = number.doubleValue() * number.doubleValue();
        System.out.println("Square = " + result);
    }
}

public class GenericDataContainer {

    public static void main(String[] args) {

        // Integer Container
        DataContainer<Integer> intObj = new DataContainer<>(25);
        intObj.display();

        // String Container
        DataContainer<String> strObj = new DataContainer<>("Java Programming");
        strObj.display();

        // Double Container
        DataContainer<Double> doubleObj = new DataContainer<>(12.5);
        doubleObj.display();

        // Generic Method
        DataContainer.printData("Welcome to Generics");
        DataContainer.printData(100);
        DataContainer.printData(45.67);

        // Bounded Type Parameter
        DataContainer.square(10);
        DataContainer.square(5.5);
    }
}
