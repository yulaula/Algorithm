import java.util.*;
public class Main {
    static int N, K;
    static int[] check = new int[100001];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        if(N == K) {
            System.out.println(0);
            return;
        } else {
            bfs(N);
        }
    }
    
    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(num);
        check[num] = 1;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            int next = 0;
            
            for(int i = 0; i < 3; i++) {
                if(i == 0) {
                    next = now - 1;
                } else if(i == 1) {
                    next = now + 1;
                } else {
                    next = 2 * now;
                }
                
                if(next == K) {
                    System.out.println(check[now]);
                    return;
                }
                
                if(0 <= next && next <= 100000 && check[next] == 0) {
                    q.offer(next);
                    check[next] = check[now] + 1;
                }
            }
        }
    }
}