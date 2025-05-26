// Define the custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class customexception {
    // Method to check age and throw exception if age < 18
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age: " + age + ". Age must be at least 18.");
        } else {
            System.out.println("Age " + age + " is valid.");
        }
    }

    public static void main(String[] args) {
        int ageToCheck = 16;  // Change this value to test

        try {
            validateAge(ageToCheck);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
