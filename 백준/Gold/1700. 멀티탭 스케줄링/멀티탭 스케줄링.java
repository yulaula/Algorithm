import java.util.*;
public class Main {
    static int N, K;
    static Set<Integer> multitap;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int[] schedule = new int[K];
        for(int i = 0; i < K; i++) {
            schedule[i] = sc.nextInt();
        }
        
        multitap = new HashSet<>();
        int cnt = 0;
        
        for(int i = 0;  i < K; i++) {
            int now = schedule[i];
            
            if(multitap.contains(now)) {
                continue;
            }
            
            if(multitap.size() < N) {
                multitap.add(now);
                continue;
            }
            
            int removed = 0;
            int lastIdx = -1;
            for(int used : multitap) {
                boolean isContain = false;
                
                for(int j = i+1; j < K; j++) {
                    if(schedule[j] == used) {
                        isContain = true;
                        if(lastIdx < j) {
                            lastIdx = j;
                            removed = schedule[j];
                        }
                        break;
                    }
                }
                
                if(!isContain) {
                    removed = used;
                    break;
                }
            }
            
            multitap.remove(removed);
            multitap.add(now);
            cnt++;
        }
        System.out.println(cnt);
    }
}