import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        
        while(n >= 2 && m >= 1 && m+n >= k+3) {
            count++;
            n -= 2;
            m--;
        }
        
        System.out.println(count);
    }
}