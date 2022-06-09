import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        int sum = 0;
        
        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for(int x = 2; x < 9; x++) {
                        System.out.println(arr[x]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}