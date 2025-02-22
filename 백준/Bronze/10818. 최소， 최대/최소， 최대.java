import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int min = 1000001;
        int max = -1000001;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(min > num) min = num;
            if(max < num) max = num;
        }
        
        System.out.println(min + " " + max);
    }
}
