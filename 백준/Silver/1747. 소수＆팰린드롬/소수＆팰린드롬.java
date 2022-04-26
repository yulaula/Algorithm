import java.util.*;
public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      for(int i = n; ; i++) {
        if(isPalindrome(i) && isPrime(i)) {
            System.out.println(i);
            break;
        }
      }
    }
    
    public static boolean isPrime(int number) {
        if(number == 1) return false;
        // 소수는 자기 자신의 제곱근보다 작은 소수들에게 나눠떨어지지않음
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome(int number) {
        String s = Integer.toString(number);
        for(int i = 0; i <= s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}