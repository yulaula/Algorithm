import java.util.*;
public class Main {
    static int N, M;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        Set<String> hs = new HashSet<String>();
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < N; i++) {
            hs.add(sc.next());
        }
        
        for(int i = 0; i < M; i++) {
            String noSee = sc.next();
            if(hs.contains(noSee)) {
                result.add(noSee);
            }
        }
        Collections.sort(result); // 사전순 출력
        
        System.out.println(result.size());
        for(String res : result) {
            System.out.println(res);
        }
    }
}