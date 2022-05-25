import java.util.*;
public class Main {
    static int N;
    static int K;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Medal> pq = new PriorityQueue<Medal>();
        N = sc.nextInt();
        K = sc.nextInt();
        
        for(int i = 0; i < N; i++) {
            int index = sc.nextInt();
            int g = sc.nextInt();
            int s = sc.nextInt();
            int b = sc.nextInt();
            pq.offer(new Medal(index, g, s, b));
        }
        
        int rank = 1;
        Medal tmp = pq.poll();
        if(tmp.index == K) {
            System.out.println(rank);
            System.exit(0);
        }
        int same = 0;
        while(!pq.isEmpty()) {
            Medal m = pq.poll();
            // 앞선 q랑 같지 않다면
            if(!(tmp.g==m.g && tmp.s==m.s && tmp.b==m.b)) {
                tmp = m;
                rank++;
                if(same > 0) {
                    rank += same;
                    same = 0;
                }
            } else { // 같다면 == 같은 등수
                same++;
            }
            
            if(m.index == K) {
                System.out.println(rank);
                System.exit(0);
            }
        }
        
    }
}
class Medal implements Comparable<Medal> {
    int index;
    int g;
    int s;
    int b;
    public Medal(int index, int g, int s, int b) {
        this.index = index;
        this.g = g;
        this.s = s;
        this.b = b;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return this.index;
    }
    public void setG(int g) {
        this.g = g;
    }
    public int getG() {
        return this.g;
    }
    public void setS(int s) {
        this.s = s;
    }
    public int getS() {
        return this.s;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getB() {
        return this.b;
    }
    @Override
    public String toString() {
        return this.index + " " + this.g + " " + this.s + " " + this.b;
    }
    @Override
    public int compareTo(Medal o) {
        if(this.g == o.g) {
            if(this.s == o.s) {
                return o.b - this.b;
            }
            return o.s-this.s;
        }
        return o.g-this.g;
    }
}