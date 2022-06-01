import java.util.*;
public class Main {
    static int N, M, V;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[] visited;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        
        dfs(V);
        
        visited = new boolean[N+1];
        System.out.println();
        
        bfs();
       
    }
    public static void dfs(int num) {
        visited[num] = true;
        System.out.print(num + " ");
        
        for(int i = 1; i <= N; i++) {
            if(arr[num][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(V);
        visited[V] = true;
        System.out.print(V + " ");
        
        while(!q.isEmpty()) {
            int tmp = q.poll();
            
            for(int i = 1; i <= N; i++) {
                if(arr[tmp][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }        
    }
}