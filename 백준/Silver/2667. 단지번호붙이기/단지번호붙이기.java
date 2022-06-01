import java.util.*;
public class Main {
    static int N, count;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static List<Integer> list;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<Integer>();
        
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
                //System.out.print(arr[i][j] + " ");
            }
            //System.out.println();
        }
        
        count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    list.add(count);                }
            }
        }
        
        Collections.sort(list);
        System.out.println(list.size());
        for(int r : list) {
            System.out.println(r);
        }
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            
            if(tmpX >= 0 && tmpY >= 0 && tmpX < N && tmpY < N) {
                if(arr[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]) {
                    dfs(tmpX, tmpY);
                    count += 1;
                }
            }
        }
    }
}