import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int answer = 0;
        int people = 0;
        for(int i = 0; i < arr.length; i++) {
            people += 1;
            if(people >= arr[i]) {
                answer++;
                people = 0;
            }
        }
        
        System.out.println(answer);
    }
}