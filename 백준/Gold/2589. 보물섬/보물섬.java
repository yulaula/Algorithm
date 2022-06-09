import java.util.*;
public class Main {
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        
        int max_num = Integer.MIN_VALUE;
        int distance = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'L') {
                    visited = new boolean[N][M];
                    distance = bfs(i, j);
                    max_num = Math.max(max_num, distance);
                    //System.out.println("max : " + max_num);
                }
            }
        }
        System.out.println(max_num);
    }
    
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;
        
        int len = 0;
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(visited[nx][ny] == false && arr[nx][ny] == 'L') {
                        q.offer(new Node(nx, ny, now.hour+1));
                        len = Math.max(len, now.hour+1);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return len;
    }
}
class Node {
    int x;
    int y;
    int hour;
    
    public Node(int x, int y, int hour) {
        this.x = x;
        this.y = y;
        this.hour = hour;
    }
}