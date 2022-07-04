import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Fail> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) { // 스테이지(+1) 순으로
            int successUser = 0;
            int failUser = 0;
            for(int j = 0; j < stages.length; j++) { // 유저의 스테이지
                if(stages[j] >= (i+1)) {
                    successUser++;
                } 
                if(stages[j] == (i+1)) {
                    failUser++;
                }
            }
            double per = (double) failUser / successUser; // 실패율
            list.add(new Fail(per, i+1));
        }
        
        Collections.sort(list);
        for(int i = 0; i < N; i++) {
            answer[i] = list.get(i).stage;
        }
        
        return answer;
    }
    
    static class Fail implements Comparable{
        double percent;
        int stage;
        public Fail(double percent, int stage) {
            this.percent = percent;
            this.stage = stage;
        }
        @Override 
        public int compareTo(Object o) {
            Fail f = (Fail) o;
            if(f.percent > this.percent) {
                return 1;
            } else if(f.percent < this.percent) {
                return -1;
            } else {
                if(f.stage < this.stage) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        @Override
        public String toString() { // 디버깅용
            return stage +" "+ percent;
        }
    }
}