import java.util.*;
public class Main {
    static int L, C;
    static char[] arr;
    static char[] result;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        result = new char[L];
        
        for(int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        
        createCode(0, 0);
        
    }
    // 코드 만들기
    public static void createCode(int cur, int index) {
        if(index == L) {
            if(check()) {
                System.out.println(result);
            }
            return;
        }
        
        for(int i = cur; i < C; i++) {
            result[index] = arr[i];
            //System.out.print(i+1 +" ");
            createCode(i+1, index+1);
        }
    }
    
    // 모음 자음 수 체크
    public static boolean check() {
        int vowel = 0; // 모음
        int cons = 0; // 자음
        
        for(char c : result) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                cons++;
            }
        }
        
        if(vowel >= 1 && cons >= 2) {
            return true;
        }
        
        return false;
    }
}