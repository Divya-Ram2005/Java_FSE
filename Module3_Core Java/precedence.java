public class precedence {
    public static void main(String[] args) {

        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1);
        // Explanation: 5 * 2 = 10 → 10 + 10 = 20

        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);
        // Explanation: 10 + 5 = 15 → 15 * 2 = 30

        int result3 = 100 / 5 + 2 * 4;
        System.out.println("100 / 5 + 2 * 4 = " + result3);
        // Explanation: 100 / 5 = 20, 2 * 4 = 8 → 20 + 8 = 28

        int result4 = 20 - 5 + 3;
        System.out.println("20 - 5 + 3 = " + result4);
        // Explanation: 20 - 5 = 15 → 15 + 3 = 18 (evaluated left to right)

        int result5 = 50 / (2 + 3) * 4;
        System.out.println("50 / (2 + 3) * 4 = " + result5);
        // Explanation: (2 + 3) = 5 → 50 / 5 = 10 → 10 * 4 = 40
    }
}