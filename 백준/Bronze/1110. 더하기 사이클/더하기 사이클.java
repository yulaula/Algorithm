import java.util.*;
public class Main {
    public static void main(String args[]) {
        
        // 0 <= x =< 9
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int count = 0;
        
        result = cycle(n);
        count += 1;
        
        while(n != result) {
            //System.out.print(result + " ");
            result = cycle(result);
            count += 1;
        }
        //System.out.println();
        System.out.println(count);
    }
    
    public static int cycle(int tmp) {
        int result = 0;
        if(tmp < 10) {
            String s1 = Integer.toString(tmp) + Integer.toString(tmp);
            result = Integer.parseInt(s1);
        } else {
            int a = tmp/10;
            int b = tmp%10;
            
            int sum = a + b;
            String sb = Integer.toString(b);
            String s2 = Integer.toString(sum);
            if(sum < 10) {
                result = Integer.parseInt(sb+s2);
            } else {
                result = Integer.parseInt(sb+s2.charAt(1));
            }
        }
        return result;
    }
}