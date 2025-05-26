import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lambdasort {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Divya");
        names.add("Rahul");
        names.add("Amit");
        names.add("Sneha");

        // Sort using lambda expression
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // Display sorted list
        System.out.println("Sorted list of names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
