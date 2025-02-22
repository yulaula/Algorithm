import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int index = -1;
        
        for(int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if(max < num) {
                max = num;
                index = i;
            }
        }
        
        System.out.println(max + "\n" + index);
    }
}
