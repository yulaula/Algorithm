import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int answer = 0;
        while (n != 1) {
            if(n % k == 0) {
                n /= k;
                answer++;
            }
            else {
                n -= 1;
                answer++;
            }
        }
        System.out.println(answer);
    }
}