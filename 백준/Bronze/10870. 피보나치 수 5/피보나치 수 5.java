import java.util.*;
public class Main {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.close();
        
        int result = pibo(n);
        System.out.println(result);
	}
    public static int pibo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        return pibo(n-2) + pibo(n-1);
    }
}