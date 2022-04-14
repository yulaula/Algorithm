import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        int[] arr = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        
        long answer = 0;
        for(int i = 0; i < str.length(); i++) {
            if(arr[i] <= 1 || answer <= 1) { // 1, 0 일때는 더하는게 낫다
                answer += arr[i]; 
            } else {
                answer *= arr[i];
            }
        }
        System.out.println(answer);
    }
}