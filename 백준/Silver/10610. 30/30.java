import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nArr = br.readLine().split("");
        boolean isZero = false;
        int sum = 0;
        Arrays.sort(nArr);

        for(String s : nArr) {
            sum += Integer.parseInt(s);
            if(s.equals("0")) {
                isZero = true;
            }
        }

        if(isZero == true && sum%3 == 0) {
            for(int i = nArr.length-1 ; i >= 0; i--) {
                System.out.print(nArr[i]);
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
    
}
