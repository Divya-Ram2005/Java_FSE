
import java.util.*;
public class simple_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer1:");
        int input1 = sc.nextInt();
        System.out.println("Enter an integer2:");
        int input2 = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter operation:");
        String op = sc.nextLine();
        if(op.equals("add"))
        System.out.println(input1+input2);
        else if(op.equals("sub"))
        System.out.println(input1-input2);
        else if(op.equals("mul"))
        System.out.println(input1*input2);
        else if(op.equals("div"))
        System.out.println(input1/input2);
        sc.close();
    }
}
