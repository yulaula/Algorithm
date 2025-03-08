import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        } 
        
        Arrays.sort(arr);
        double max = arr[N-1]; 
        //System.out.println("max : " + max);
        
        arr = scoreChange(arr, max); // 점수변환
        bw.write(aveCal(arr) + ""); // 평균
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    static double[] scoreChange(double[] arr, double max) {
        for(int i = 0; i < arr.length; i++) {
            //System.out.println("arr 1 " + arr[i]);
            arr[i] = arr[i] / max * 100;
            //System.out.println("arr 2 " + arr[i]);
        }
        return arr;
    }
    
    static double aveCal(double[] arr) {
        double total = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total / arr.length;
    }
}
 