// Base class
class Animal {
    // Method to be overridden
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass
class Dog extends Animal {
    // Override the makeSound method
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class inheritance {
    public static void main(String[] args) {
        // Create an Animal object
        Animal genericAnimal = new Animal();
        genericAnimal.makeSound();  // Outputs: Some generic animal sound

        // Create a Dog object
        Dog dog = new Dog();
        dog.makeSound();  // Outputs: Bark
    }
}
