import java.util.*;
public class Main {
    
    public static int[] d = new int[30001]; // 연산 수
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        
        for(int i = 2; i <= x; i++) {
            d[i] = d[i-1] + 1; // 1 빼니까 연산 1+
            
            if(i % 2 == 0) {
                d[i] = Math.min(d[i], d[i/2] + 1);
            }
            if(i % 3 == 0) {
                d[i] = Math.min(d[i], d[i/3] + 1);
            }
            if(i % 5 == 0) {
                d[i] = Math.min(d[i], d[i/5] + 1);
            }
        }
        
        for(int i = 2; i <= x; i++) {
            System.out.print(d[i] +" ");
        }
        System.out.println();
        System.out.println(d[x]);
    }
    
}
