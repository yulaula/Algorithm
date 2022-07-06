import java.util.*;
public class Main {
    static int t, n;
    static String[] arr;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int test = 0; test < t; test++) {
            n = sc.nextInt();
            arr = new String[n];
            boolean flag = false;
            
            for(int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            
            Arrays.sort(arr);
            
            for(int i = 1; i < n; i++) {
                if(arr[i].startsWith(arr[i-1])) {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}