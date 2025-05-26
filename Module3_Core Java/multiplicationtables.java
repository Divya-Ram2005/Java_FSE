import java.util.*;
public class multiplicationtables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer:");
        int input = sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(input+"*"+i+"="+(input*i));
        }
        sc.close();
    }
}
