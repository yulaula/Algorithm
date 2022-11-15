import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        String answer = check(str);
        
        System.out.println(answer);
    }
    public static String check(String str) {
        char[] arr = new char[str.length()];
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
            sum += arr[i] - '0';
        }
        
        Arrays.sort(arr);
        if(arr[0] != '0') {
            return "-1";
        }
        if(sum%3 != 0) {
            return "-1";
        }
        
        String a = new String();
        for(int i = arr.length-1; i >= 0; i--) {
            a += arr[i] + "";
        }
        
        return a;
    }
}