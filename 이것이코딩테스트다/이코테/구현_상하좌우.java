import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        int[] loc = {1, 1};
        String s = sc.nextLine();
        String[] mov = s.split(" ");
        
        for(int i = 0 ; i < mov.length; i++) {
            if(mov[i].equals("L")) {
                if(loc[1] - 1 > 0) {
                    loc[1] -= 1;
                }
            }
            else if(mov[i].equals("R")) {
                if(loc[1] + 1 <= n) {
                    loc[1] += 1;
                }
            }
            else if(mov[i].equals("U")) {
                if(loc[0] - 1 > 0) {
                    loc[0] -= 1;
                }
            }
            else {
                if(loc[0] + 1 <= n) {
                    loc[0] += 1;
                }
            }
        }
        
        System.out.println(loc[0] + " " + loc[1]);
    }
}

// int dx[4] = {0, 0, -1, 1};
// int dy[4] = {-1, 1, 0, 0};
// char[] moveTypes = {'L', 'R', 'U', 'D'};
