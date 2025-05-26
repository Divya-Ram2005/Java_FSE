// Custom Exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class exception {
    // Method to check age and throw exception if invalid
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is not valid. Must be at least 18.");
        } else {
            System.out.println("Age " + age + " is valid.");
        }
    }

    public static void main(String[] args) {
        int[] testAges = {15, 20, 17};

        for (int age : testAges) {
            try {
                checkAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Caught Exception: " + e.getMessage());
            }
        }
    }
}
