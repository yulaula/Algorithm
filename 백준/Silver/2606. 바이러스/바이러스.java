import java.util.*;
public class Main {
    static int N;
    static int K;
    static int[][] graph;
    static boolean[] visited;
    static int virus = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[N+1];
        graph = new int[N+1][N+1];
        for(int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        dfs(1);
        System.out.println(virus);
    }
    
    public static void dfs(int num){
        if(num == 1) {
            virus = 0;
        } else {
            virus += 1;
        }
        visited[num] = true;
        
        for(int i = 0; i <= N; i++) {
            if(graph[num][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}