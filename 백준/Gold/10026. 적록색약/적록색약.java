import java.util.*;
public class Main {
    static int N;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
                //System.out.print(arr[i][j] + " ");
            }
            //System.out.println();
        }
        
        //적록색약 X
        int normal = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    normal += 1;
                }
            }
        }
        
        //적록색약 O
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        
        int abnormal = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    abnormal += 1;
                }
            }
        }
        
        System.out.println(normal + " " + abnormal);
    }
    
    public static void dfs(int x, int y) {
        
        visited[x][y] = true;
        char tmpC = arr[x][y];
        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            
            if(tmpX >= 0 && tmpY >= 0 && tmpX < N && tmpY < N) {
                if(!visited[tmpX][tmpY] && arr[tmpX][tmpY] == tmpC) {
                    dfs(tmpX, tmpY);
                }
            }
        }
    }
}