import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine()); // 중복제거
        }
        
        String[] arr = new String[set.size()];
        set.toArray(arr);
        
        Arrays.sort(arr, new Comparator<String>() { // ⭐️⭐️⭐️⭐️
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        }); 
        
        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
