import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        br.close();
        System.out.println(factorial(N));
        
    }
    
    static long factorial(int N) {
        if(N <= 0) {
            return 1;
        }
        
        return N * factorial(N-1);
    }
}
