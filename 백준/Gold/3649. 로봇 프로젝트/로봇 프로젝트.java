import java.util.*;
public class Main {
    /*
        x   센티미터 구멍의 너비
            구멍에 넣을 두 조각의 길이의 합 = 구멍의 너비
        n   레고 조각의 수
        l   레고 조각의 길이
        1 cm = 10000000 nm
    */
    static long x;
    static int n;
    static long[] len;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextInt()) {
            x = sc.nextLong() * 10000000;
            n = sc.nextInt();
            len = new long[n];
            for(int i = 0; i < n; i++) {
                len[i] = sc.nextLong();
            }
            Arrays.sort(len);
        
            int left = 0, right = n-1;
            boolean flag = false;
        
            while(left < right) {
                long sum = len[left] + len[right];
                if(sum == x) {
                    flag = true;
                    break;
                } else if(sum > x) {
                    right--;
                } else {
                    left++;
                }
            }
            if(!flag) {
                System.out.println("danger");
            } else {
                System.out.println("yes " + len[left] +" " + len[right]);
            }
        }
    }
}