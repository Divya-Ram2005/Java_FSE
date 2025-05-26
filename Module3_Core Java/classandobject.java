// Car class definition
class Car {
    // Attributes
    String make;
    String model;
    int year;

    // Constructor to initialize a Car object
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println();
    }
}

public class classandobject {
    public static void main(String[] args) {
        // Creating Car objects
        Car car1 = new Car("Toyota", "Corolla", 2019);
        Car car2 = new Car("Honda", "Civic", 2021);

        // Calling method to display details
        car1.displayDetails();
        car2.displayDetails();
    }
}
