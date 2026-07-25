class ParkingSystem {

    private int[] slots;

    // Constructor
    public ParkingSystem(int big, int medium, int small) {
        slots = new int[4];   // Index 1 -> big, 2 -> medium, 3 -> small
        slots[1] = big;
        slots[2] = medium;
        slots[3] = small;
    }

    // Method to add a car
    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {

        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        System.out.println(parkingSystem.addCar(1)); // true
        System.out.println(parkingSystem.addCar(2)); // true
        System.out.println(parkingSystem.addCar(3)); // false
        System.out.println(parkingSystem.addCar(1)); // false
    }
}
