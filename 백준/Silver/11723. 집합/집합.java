import java.io.*;
import java.util.*;
 
public class Main {
 
  /* Set (중복을 허용하지 않음) */
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
  static Set<Integer> s = new HashSet<>();
 
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
 
    int m = Integer.parseInt(br.readLine());
 
    for(int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        String cal = st.nextToken();
 
        switch(cal) {
            // 집합에 x 추가
            case "add" :
                add(Integer.parseInt(st.nextToken()));
                break;
            // 집합에서 x 제거
            case "remove" :
                remove(Integer.parseInt(st.nextToken()));
                break;
            // 집합에 x가 있으면 1, 없으면 0
            case "check" :
                check(Integer.parseInt(st.nextToken()));
                break;
            // 집합에 x가 있으면 제거, 없으면 추가
            case "toggle" :
                toggle(Integer.parseInt(st.nextToken()));
                break;
            // 집합 {1,2,...,20}
            case "all" :
                all();
                break;
            // 공집합
            case "empty" :
                empty();
                break;
        }
    }
 
    bw.flush();
    bw.close(); 
  }
 
  static void add(int x) {
      s.add(x);
  }
 
  static void remove(int x) {
      s.remove(x);
  }
 
  static void check(int x) throws IOException {
      if(s.contains(x)) {
          bw.write(1 + "\n");
      } else {
          bw.write(0 + "\n");
      }
  }
 
  static void toggle(int x) {
      if(s.contains(x)) {
          s.remove(x);
      } else {
          s.add(x);
      }
  }
 
  static void all() {
      for(int i = 1; i <= 20; i++) {
          s.add(i);
      }
  }
 
  static void empty() {
      s.clear();
  }
}