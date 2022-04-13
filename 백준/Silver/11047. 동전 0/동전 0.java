import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int len = sc.nextInt();
        int price = sc.nextInt();
        
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = greedy(arr, price);
        System.out.println(answer);
    }
    
    public static int greedy(int[] arr, int price) {
        int answer = 0;
        
        for(int i = arr.length-1; i >= 0; i--) {
            if(price / arr[i] >= 1) {
                answer += price/arr[i];
                price = price % arr[i];
            }
        }
        
        return answer;
    }
}