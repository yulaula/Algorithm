import java.util.*;
import java.io.*;

public class Main
{
    /* 초코바 */
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        br.close();
        
        if(N*100 >= M) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
