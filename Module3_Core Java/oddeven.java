import java.util.*;
public class oddeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer1:");
        int input1 = sc.nextInt();
        sc.nextLine(); 
        if((input1%2)==0){
            System.out.println("the given integer is even");
        }
        else{
            System.out.println("the given integer id Odd");
        }
        sc.close();
    }
    
}
