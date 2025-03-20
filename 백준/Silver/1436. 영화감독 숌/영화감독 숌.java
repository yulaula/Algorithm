import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int num = 666; // 가장 작은 666포함 수
        
        while(N != cnt) {
            num++;
            if(String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
        
        bw.write(num+"");
        
        br.close();
        bw.flush();
        bw.close();
    }
}
