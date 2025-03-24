import java.util.*;

import java.io.*;


 

public class Main

{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int con = 0;

        for(int i = 1; i < N; i++) {
            if(N == sum(i)) {
                con = i;
                break;
            }
        }
        bw.write(con + " ");

        br.close();
        bw.flush();
        bw.close();
    }

    static int sum(int num) {
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();

        int result = num;
        for(int i = 0; i < arr.length; i++) {
            result += (arr[i] - '0');
        }
        return result;
    }
}