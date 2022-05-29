import java.util.*;
public class Main {
    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> list;
    static int size;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        size += 1;
        
        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            
            if(tmpX >= 0 && tmpY >= 0 && tmpX < N && tmpY < M) {
                if(arr[tmpX][tmpY] == 0 && !visited[tmpX][tmpY]) {
                    dfs(tmpX, tmpY);
                }
            }
        }
        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        int x1, y1, x2, y2;
        for(int i = 0; i < K; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            
            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    arr[x][y] = 1;
                }
            }
        }
        list = new ArrayList<Integer>();
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                size = 0;
                if(arr[x][y] == 0 && !visited[x][y]) {
                    dfs(x, y);
                    list.add(size);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}