import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int result = 0;
        String n = sc.nextLine();
        int x = (int)(n.charAt(0) - 'a');
        int y = (int)(n.charAt(1) - '1');
        //System.out.println(x + " " + y);
        
        int[] dx = {-2, -2, 2, 2, 1, -1, 1, -1};
        int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};
        
        for(int i = 0; i < dx.length; i++) {
            int tmp_x = x + dx[i];
            int tmp_y = y + dy[i];
            
            if((tmp_x >= 0 && tmp_x < 8) && (tmp_y >= 0 && tmp_y < 8)) {
                result++;
            }
        }
        System.out.println(result);
        
    }
}
