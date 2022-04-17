import java.util.*;
public class Main {
    public static int[] visited = {};
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 3000001;
        
        while(!q.isEmpty()) {
            int s = q.poll();
            for(int i = 0; i < graph.get(s).size(); i++) {
                int d = graph.get(s).get(i);
                if(visited[d] == 0) {
                    q.offer(d);
                    if(visited[s] == 3000001) visited[d] += 1;
                    else visited[d] = visited[s] + 1;
                }
            }
        }
    }
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt(); // 도시의 개수
      int m = sc.nextInt(); // 도로의 개수
      int k = sc.nextInt(); // 거리 정보
      int x = sc.nextInt(); // 출발 도시 번호
      visited = new int[n+1];
      for(int i = 0; i <= n; i++) {
          graph.add(new ArrayList<Integer>());
      }
      
      for(int i = 0; i < m; i++) {
          int start = sc.nextInt();
          int end = sc.nextInt();
          //System.out.println(start + "  " + end);
          graph.get(start).add(end);
      }
      
      bfs(x);
      
      //for(int i = 0; i < visited.length; i++) {
      //   System.out.println(visited[i]);
      //}
      
      int count = 0;
      for(int i = 0; i < visited.length; i++) {
          if(visited[i] == k) {
              System.out.println(i);
              count++;
          }
      }
      if(count == 0) {
          System.out.println(-1);
      }
     
    }
}