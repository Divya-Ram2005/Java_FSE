public class methodoverloading {

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        // Calling each overloaded method
        int sum1 = add(5, 10);               // two integers
        double sum2 = add(3.5, 4.5);         // two doubles
        int sum3 = add(1, 2, 3);             // three integers
        System.out.println("Sum of 5 and 10 (int): " + sum1);
        System.out.println("Sum of 3.5 and 4.5 (double): " + sum2);
        System.out.println("Sum of 1, 2 and 3 (int): " + sum3);
    }
}
