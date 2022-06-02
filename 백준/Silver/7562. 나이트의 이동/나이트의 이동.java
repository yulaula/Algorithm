import java.util.*;
class Chess {
    int x; 
    int y;
    public Chess(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, L;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};
    static Queue<Chess> q;
    static Chess start, end;
    static List<Integer> list = new ArrayList<Integer>();
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            L = sc.nextInt();
            arr = new int[L][L];
            visited = new boolean[L][L];
            q = new LinkedList<Chess>();
            
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            start = new Chess(sx, sy);
            end = new Chess(ex, ey);
            
            visited[sx][sy] = true;
            q.offer(start);
            bfs();
        }
        
        for(int i = 0; i < N; i++) {
            System.out.println(list.get(i));
        }
    }
    
    public static void bfs() {
        
        while(!q.isEmpty()) {
            Chess c = q.poll();
            int x = c.x;
            int y = c.y;
            
            // 목표지점 도착
            if(x == end.x && y == end.y) {
                list.add(arr[x][y]);
                return;
            }
            
            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0  || ny < 0 || nx >= L || ny >= L) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                
                q.offer(new Chess(nx, ny));
                arr[nx][ny] = arr[x][y] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}
