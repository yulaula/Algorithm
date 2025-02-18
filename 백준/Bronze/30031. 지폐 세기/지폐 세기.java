import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int result = 0;
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            
            switch(width) {
                case 136 :
                    result += 1000;
                    break;
                case 142 :
                    result += 5000;
                    break;
                case 148 : 
                    result += 10000;
                    break;
                case 154 :
                    result += 50000;
                    break;
            }
            int height = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        System.out.println(result);
    }
}
