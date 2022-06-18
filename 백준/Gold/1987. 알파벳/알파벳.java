import java.util.*;
public class Main {
    static int R, C;
    static int max = 0;
    static int[][] arr;
    static boolean[] check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new int[R][C];
        check = new boolean[26];
        for(int i = 0; i < R; i++) {
            String s = sc.next();
            for(int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j)-'A';
            }
        }
        
        dfs(0, 0, 0);
        System.out.println(max);
        
    }
    public static void dfs(int x, int y, int count) {
        if(check[arr[x][y]]) {
            max = Math.max(max, count);
            return;
        }
        
        check[arr[x][y]] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }
            
            dfs(nx, ny, count+1);
        }
        
        check[arr[x][y]] = false;
        
    }
}