import java.util.*;
public class Main {
    static int T, M, N, K;
    static int[][] c;
    static boolean[][] visited;
    static int bug;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            
            if(tmpX >= 0 && tmpY >=0 && tmpX < M && tmpY < N) {
                if(c[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]) {
                    dfs(tmpX, tmpY);
                }
            }
        }
        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            bug = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            c = new int[M][N];
            visited = new boolean[M][N];
            K = sc.nextInt();
            for(int j = 0; j < K; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                c[a][b] = 1;
            }
            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    if(c[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        bug++;
                    }
                }
            }
            System.out.println(bug);
        }
    }
}