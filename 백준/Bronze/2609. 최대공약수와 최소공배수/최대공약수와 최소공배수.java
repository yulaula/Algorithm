import java.io.*;
import java.util.*;

public class Main
{
    /*
        - 유클리드 호제법
        최대공약수 GCD
        최대공배수 LCM : 최소 공배수는 두 수의 곱에 최대 공약수를 나눈 값과 같습니다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        bw.write(gcd(a, b) + "\n" + lcm(a, b));
        br.close();
        bw.flush();
        bw.close();
    }
    
    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    static int lcm(int a, int b) {
        return a*b / gcd(a, b);
    }
}
