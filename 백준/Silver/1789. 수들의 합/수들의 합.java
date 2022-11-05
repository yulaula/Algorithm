import java.util.*;

public class Main {
    static long S;
    static long sum;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextLong();
        sum = 0L;
        cnt = 0;
        while(true) {
            sum += cnt;
            if(sum > S) 
                break;
            cnt++;
        }
        System.out.println(--cnt);

        sc.close();
    }
}

