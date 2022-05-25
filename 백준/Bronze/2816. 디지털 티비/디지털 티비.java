import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] channel = new String[n];
        for(int i = 0; i < n; i++) {
            channel[i] = sc.next();
        }
        
        // KBS1 index0 에 두기
        for(int i = 0; i < n; i++) {
            if(channel[0].equals("KBS1")) {
                break;
            }
 
            if(channel[i].equals("KBS1")) {
                for(int j = i; j > 0; j--) {
                    String tmp = channel[j];
                    channel[j] = channel[j-1];
                    channel[j-1] = tmp;
                    
                    System.out.print(4);
                }
                break;
                
            } else {
                System.out.print(1);
            }
        }
        
        // KBS2 index1에두기
        for(int i = 0; i < n; i++) {
            if(channel[1].equals("KBS2")) {
                System.exit(0);
            }
            if(channel[i].equals("KBS2")) {
                for(int j = i; j > 1; j--) {
                    String tmp = channel[j];
                    channel[j] = channel[j-1];
                    channel[j-1] = tmp;
                    
                    System.out.print(4);
                }
                break;
                
            } else {
                System.out.print(1);
            }
        }
    }
}