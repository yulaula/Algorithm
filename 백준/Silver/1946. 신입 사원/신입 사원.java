import java.util.*;
public class Main {
    static int T, N;
    static List<Grade> list; 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        
        for(int i = 0; i < T; i++) {
            N = sc.nextInt();
            list = new ArrayList<Grade>();
            
            for(int j = 0; j < N; j++) {
                int docu = sc.nextInt();
                int inte = sc.nextInt();
                list.add(new Grade(docu, inte));
            }
            Collections.sort(list);
            
            int ans = 1;
            int inteHigh = list.get(0).i;
            
            for(int j = 1; j < N; j++) {
                Grade ap = list.get(j);
                if(inteHigh > ap.i) {
                    ans++;
                    inteHigh = ap.i;
                }
            }
            System.out.println(ans);
        }
        
    }
    static class Grade implements Comparable<Grade> {
        int d;
        int i;
        public Grade(int d, int i) {
            this.d = d;
            this.i = i;
        }
        @Override
        public int compareTo(Grade g) {
            if(this.d > g.d) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}