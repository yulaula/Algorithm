import java.util.*;
import java.io.*;

/* 로프 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int max = 0;
        for(int i = 0; i < N; i++) {
            // 로프가 버티는 중량 중 최소값 * 로프의 수 > 현재 최대값
            if(arr[i] * (i+1) > max) {
                max = arr[i] * (i+1);
            }
        }

        System.out.println(max);
    }
}
