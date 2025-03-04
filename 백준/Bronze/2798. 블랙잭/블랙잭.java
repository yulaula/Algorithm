import java.util.*;
import java.io.*;

/*
    브루드포스 알고리즘 필요(전체탐색)
*/
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        bw.write(blackJack(N, M, cards) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    static int blackJack(int N, int M, int[] cards) {
        
        int max = -1;
        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {
                    int num = cards[i] + cards[j] + cards[k];
                    
                    if(num > M) continue;
                    else if(num == M) return num;
                    else if (num <= M && num > max) max = num;
                }
            }
        }
        return max;
    }
}
