import java.util.*;
import java.io.*;

/*
    티셔츠 - S M L XL XXL XXXL 같은 사이즈 T장 묶음(초과 구매 가능)
    펜 - P자루씩 묶음 or 한자루(인원수 맞춤 구매)
    
*/
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine()); // 참가자 수
        int[] size = new int[6];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken()); // 사이즈별 신청
        }
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        for(int i = 0; i < 6; i++) {
            cnt += size[i] / T;
            cnt = size[i] % T > 0 ? cnt+1 : cnt; 
        }
        
        bw.write(cnt + "\n");
        bw.write(N/P + " " + N%P);
        
        br.close();
        bw.flush();
        bw.close();
    }
}
