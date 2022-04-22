import java.util.*;
public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      String s = sc.nextLine();
      int len = s.length();
      
      String s1 = s.substring(0, len/2);
      String s2 = s.substring(len/2, len);
      
      char[] c1 = s1.toCharArray();
      char[] c2 = s2.toCharArray();
      
      int sum1 = 0;
      int sum2 = 0;
      for(int i = 0; i < c1.length; i++) {
          sum1 += c1[i] - '0';
          sum2 += c2[i] - '0';
      }
      if(sum1 == sum2) {
          System.out.println("LUCKY");
      } else {
          System.out.println("READY");
      }
      
      //System.out.println(s1 + " " + s2);
    }
}