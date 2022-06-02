import java.util.*;
class Tomato {
    int x;
    int y;
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int M, N;
    static int[][] arr;
    static int count;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Tomato> q;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N][M];
        q = new LinkedList<Tomato>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                
                if(arr[i][j] == 1) {
                    q.offer(new Tomato(i, j));
                }
            }
        }
        
        System.out.println(bfs());
        
    }
    
    public static int bfs() {
        
        while(!q.isEmpty()) {
            Tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0  && ny >= 0 && nx < N && ny < M) {
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[x][y] + 1; // 소요 시간 체크
                        q.offer(new Tomato(nx, ny));
                    }
                }
            }
        }
        
        int day = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) { // 안익은 토마토가 있을 때
                    return -1;
                } 
                
                day = Math.max(day, arr[i][j]);
            }
        }
        // 처음부터 다 익었을 때
        if(day == 1) {
            return 0;
        }
        
        // 순차적으로 익었을 때, 소요 날짜 반환
        return day - 1;
    }
    
}
