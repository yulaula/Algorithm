import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 떡의 개수
        int m = sc.nextInt(); // 떡의 요청길이
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = (int)1e9;
        
        int result = 0;
        while(start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            
            for(int i = 0; i < n; i++) {
                if(arr[i] > mid) {
                    total += arr[i]-mid;
                }
            }
            if(total < m) {
                end = mid -1 ;
            } else {  // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                start = mid + 1;
                result = mid; // 최대한 덜 잘랐을 때가 정답이라 result에 기록
            }
        }
        System.out.println(result);
    }
}
