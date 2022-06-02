import java.util.*;
class Coordinate {
    int x; 
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Coordinate> q;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<Coordinate>();
        
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
        
    }
    
    public static void bfs(int a, int b) {
        
        q.offer(new Coordinate(a, b));
        
        while(!q.isEmpty()) {
            Coordinate c = q.poll();
            int x = c.x;
            int y = c.y;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0  || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(visited[nx][ny] || arr[nx][ny] == 0) {
                    continue;
                }
                
                q.offer(new Coordinate(nx, ny));
                arr[nx][ny] = arr[x][y] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}
