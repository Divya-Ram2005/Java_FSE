import java.util.*;
public class leapyear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int input = sc.nextInt();

        if( (input%4)==0 && ((input%100)!=0 ||(input%400)==0))
            System.out.println(" this is leap year");
        else 
            System.out.println("it is not lepa year");
        sc.close();
    }

}
