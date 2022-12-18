import java.util.*;

/* 14659 한조서열정리하고옴ㅋㅋ */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = Integer.MIN_VALUE;
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = i+1; j < N; j++) {
                // 내 봉우리보다 높으면 처치 못함
                if(arr[i] < arr[j]) {
                    break;
                } else {
                    cnt++;
                }
            }
            result = Math.max(cnt, result);
        }
        System.out.println(result);
    }
}
