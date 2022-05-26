import java.util.*;
public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        int count = 0;
        
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        
        System.out.println(count);
        
    }
    public static void dfs(int start) {
        visited[start] = true;
        
        for(int i = 1; i <= N; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}