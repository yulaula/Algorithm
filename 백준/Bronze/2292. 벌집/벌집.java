import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int range = 2;
        int room = 1;
        
        if(N == 1) { // 1일경우 방 1개
            bw.write("1");
        } else {
            while(N >= range) { // 각 층의 최소값보다 같거나 커야 해당 층 이상~
                range = range + (6 * room); // 1, 2~7, 8~19, 20~37
                room++;
            }
            bw.write(room + " ");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
