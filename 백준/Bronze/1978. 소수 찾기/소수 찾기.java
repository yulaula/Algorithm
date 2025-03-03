import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] arr = isPrime(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!arr[num]) cnt++;
            //System.out.println(num + " " + arr[num]);
        }

        bw.write(cnt + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean[] isPrime(int N) {
        boolean[] prime = new boolean[1001];

        // 소수가 아니면 true, 소수면 false
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= 1000; i++){
            if(prime[i]) continue;

            for(int j = i*i; j <= 1000; j+=i) {
                prime[j] = true;
                //System.out.println(j + " " + prime[j]);
            }
        }
        return prime;
    }
    
}
