import java.util.*;
public class Main {
    public static int[][] ice = new int[1000][1000];
    public static int n, m;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for(int j = 0; j < m; j++) {
                ice[i][j] = s.charAt(j) - '0';
            }
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
    
    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        if(ice[x][y] == 0) {
            ice[x][y] = 1;
            
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            
            return true;
        }
        return false;
    }
}
