import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a); //무방향 그래프
            
        }
        
        // 정점 번호가 작은 순서대로 방문 
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        // DFS 
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        
        // BFS
        visited = new boolean[N + 1];
        bfs(V);
        
        br.close();
    }
    
    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        
        for(int next : graph[v]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
    
    static void bfs(int start) {
        Queue<Integer> q  = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");
            
            for(int next : graph[v]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
