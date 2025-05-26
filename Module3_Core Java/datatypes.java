import java.util.Scanner;

public class datatypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int myInt = sc.nextInt();
        System.out.print("Enter a float value: ");
        float myFloat = sc.nextFloat();
        System.out.print("Enter a double value: ");
        double myDouble = sc.nextDouble();
        System.out.print("Enter a character: ");
        char myChar = sc.next().charAt(0);
        System.out.print("Enter true or false: ");
        boolean myBoolean = sc.nextBoolean();
        System.out.println("\n--- You Entered ---");
        System.out.println("Integer: " + myInt);
        System.out.println("Float: " + myFloat);
        System.out.println("Double: " + myDouble);
        System.out.println("Character: " + myChar);
        System.out.println("Boolean: " + myBoolean);

        sc.close();
    }
}