import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[n][n];
      
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            arr[i] = s.toCharArray();
        }
        
        int row = 0;
        int col = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                if(arr[i][j] == '.') {
                    if( (j+1 < n) && (arr[i][j+1] == '.')) {
                        if( (j+2 >= n) || (j+2 < n && arr[i][j+2] == 'X')) {
                            row += 1;
                        }
                    }
                    
                    if( (i+1 < n) && (arr[i+1][j] == '.')) {
                        if( (i+2 >= n) || (i+2 < n && arr[i+2][j] == 'X')) {
                            col += 1;
                        }
                    }
                }
            }
        }
        
        System.out.println(row + " " + col);
    } 
}