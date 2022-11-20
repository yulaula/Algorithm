import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Grade> list = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int doc = Integer.parseInt(st.nextToken());
                int itv = Integer.parseInt(st.nextToken());

                list.add(new Grade(doc, itv));
            }

            Collections.sort(list); // 서류 등수 순으로 정렬

            int result = 1; // 1등 확보
            int itvTmp = list.get(0).itv;

            for(int j = 1;  j < N; j++) {
                Grade g = list.get(j);
                if(itvTmp > g.itv) { // 면접 순위가 더 높으면
                    result++;
                    itvTmp = g.itv;
                }
            }
            System.out.println(result);
        }
    }
}

class Grade implements Comparable<Grade> {
    int doc;
    int itv;
    public Grade(int doc, int itv) {
        this.doc = doc;
        this.itv = itv;
    }

    @Override
    public int compareTo(Grade o) {
        if(this.doc > o.doc) {
            return 1;
        } else {
            return -1;
        }
    } 
}
