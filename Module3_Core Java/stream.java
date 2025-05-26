import java.util.*;
import java.util.stream.Collectors;

// Define a record
record Person(String name, int age) {}

public class stream {
    public static void main(String[] args) {
        // Create a list of Person records
        List<Person> people = List.of(
            new Person("Alice", 22),
            new Person("Bob", 30),
            new Person("Charlie", 18),
            new Person("Diana", 25)
        );

        // Print all persons
        System.out.println("All Persons:");
        people.forEach(System.out::println);

        // Filter persons aged 21 and above
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 21)
                                    .collect(Collectors.toList());

        // Print filtered list
        System.out.println("\nPersons aged 21 and above:");
        adults.forEach(System.out::println);
    }
}
