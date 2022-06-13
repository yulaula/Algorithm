import java.util.*;
public class Main {
    static int N;
    static int result;
    static int[] arr;
    static int[] tmpArr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new int[N];
 
        for(int i = 0; i < N; i++) {
            arr[i] =sc.nextInt();
        }
 
        Arrays.sort(arr);
 
        visited = new boolean[N];
        tmpArr = new int[N];
        result = Integer.MIN_VALUE;
        permutation(0);
        
        System.out.println(result);
    }
    private static void permutation(int index){
        if(index == N){
            int sum = 0;
            for (int i = 0; i < N-1 ; i++) {
                sum += Math.abs(tmpArr[i] - tmpArr[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }
 
        for (int i = 0; i < N; i++) { 
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            tmpArr[index] = arr[i];
            permutation(index + 1);
            visited[i] = false;
        }
    }
}
  