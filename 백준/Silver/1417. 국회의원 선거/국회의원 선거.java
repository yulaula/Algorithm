import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N-1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(!pq.isEmpty() && dasom <= pq.peek()) {
            // pq가 비어있지않고, dasom이 최고 득표자보다 적어야 loop
            
            dasom++;
            result++;
            pq.offer(pq.poll() - 1);
        }
        System.out.println(result);
    }
}
