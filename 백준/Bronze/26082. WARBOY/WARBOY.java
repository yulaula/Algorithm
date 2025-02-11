import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int a = Integer.parseInt(st.nextToken()); // 경쟁사 제품의 가격
        int b = Integer.parseInt(st.nextToken()); // 경쟁사 제품의 성능
        int c = Integer.parseInt(st.nextToken()); // WARBOY의 가격
        
        // 가격대비성능 = 성능/가격
        int warboy = ((b/a) * 3) * c;
    
        bw.write(warboy + "");
        bw.flush();
        bw.close();
    }
}
