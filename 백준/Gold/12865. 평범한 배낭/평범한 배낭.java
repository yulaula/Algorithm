import java.util.*;
public class Main {
    static int N, K;
    static int[] W;
    static int[] V;
    static int[][] dp;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt(); // 물품의 수
        K = sc.nextInt(); // 버틸 수 있는 무게
        W = new int[N+1]; // 각 물건의 무게
        V = new int[N+1]; // 각 물건의 가치
        dp = new int[N+1][K+1]; // dp[물품index][무게] = 가치
        
        for(int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - W[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}