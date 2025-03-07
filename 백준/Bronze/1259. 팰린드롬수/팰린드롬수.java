import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            if("0".equals(str)) {
                break;  
            }
            
            StringBuffer sb = new StringBuffer(str);
            String revStr = sb.reverse().toString();
            
            if(revStr.equals(str)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();   
    }
}